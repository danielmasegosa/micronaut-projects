package recomendation.microservice.client.bookcatalogue

import catalogue.microservice.model.Book
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable

@Client(id = "bookcatalogue")
interface BookCatalogueClient: BookCatalogueOperations {

    @Get("/books")
    override fun findAll(): Flowable<Book>
}