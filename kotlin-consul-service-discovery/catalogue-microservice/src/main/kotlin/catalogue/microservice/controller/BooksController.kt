package catalogue.microservice.controller

import catalogue.microservice.model.Book
import catalogue.microservice.service.BooksService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.validation.Validated
import javax.validation.constraints.NotEmpty

@Validated
@Controller("/books")
class BooksController(val booksService: BooksService,
                      val embeddedServer: EmbeddedServer) {

    @Get
    internal fun getAllBooks() : List<Book> {
        print(embeddedServer.port)
        return booksService.findAllBooks()
    }

    @Post
    internal fun insertBook(@NotEmpty book: Book): Book {
        print(embeddedServer.port)
        return booksService.insertBook(book)
    }
}