package catalogue.microservice.controller

import catalogue.microservice.model.Book
import catalogue.microservice.service.BooksService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.constraints.NotEmpty

@Validated
@Controller("/books")
class BooksController(val booksService: BooksService,
                      val embeddedServer: EmbeddedServer) {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Get
    internal fun getAllBooks() : List<Book> {
        logger.info("Running on port ${embeddedServer.port}")
        return booksService.findAllBooks()
    }

    @Post
    internal fun insertBook(@NotEmpty book: Book): Book {
        logger.info("Running on port ${embeddedServer.port}")
        return booksService.insertBook(book)
    }
}