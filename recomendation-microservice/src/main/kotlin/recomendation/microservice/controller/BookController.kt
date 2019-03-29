package recomendation.microservice.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Flowable
import recomendation.microservice.client.bookcatalogue.BookCatalogueOperations
import recomendation.microservice.client.bookinventory.BookInventoryOperations
import recomendation.microservice.model.BookRecommendation

@Controller("/books")
class BookController(private val bookCatalogueOperations: BookCatalogueOperations,
                     private val bookInventoryOperations: BookInventoryOperations) {

    @Get("/")
    fun index(): Flowable<BookRecommendation> {
        return bookCatalogueOperations.findAll()
                .flatMapMaybe { b ->
                    bookInventoryOperations.stock(b.isbn)
                            .filter { hasStock -> hasStock }
                            .map { b }
                }.map { book -> BookRecommendation(book.name) }
    }
}