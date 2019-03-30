package recomendation.microservice.controller

import catalogue.microservice.model.Book
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import recomendation.microservice.client.bookcatalogue.CatalogueOperations
import javax.validation.constraints.NotEmpty

@Controller("/api/{api.version: v1}/books")
class CatalogueController(private val catalogueOperations: CatalogueOperations) {

    @Get
    internal fun getAllBooks() : List<Book> {
        return catalogueOperations.findAll()
    }

    @Post
    internal fun insertBook(@NotEmpty bookInventory: Book): Book {
        return catalogueOperations.insertBook(bookInventory)
    }
}