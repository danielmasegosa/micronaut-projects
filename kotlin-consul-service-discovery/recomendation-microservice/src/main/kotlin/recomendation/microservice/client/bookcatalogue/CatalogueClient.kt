package recomendation.microservice.client.bookcatalogue

import catalogue.microservice.model.Book
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client(id = "bookcatalogue")
interface CatalogueClient: CatalogueOperations {

    @Get("/books")
    override fun findAll(): List<Book>

    @Post("/books")
    override fun insertBook(book: Book): Book
}