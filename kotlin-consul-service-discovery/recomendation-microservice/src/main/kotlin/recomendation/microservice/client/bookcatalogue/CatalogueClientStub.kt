package recomendation.microservice.client.bookcatalogue

import catalogue.microservice.model.Book
import io.micronaut.retry.annotation.Fallback
import org.slf4j.LoggerFactory

@Fallback
class CatalogueClientStub: CatalogueOperations {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun findAll(): List<Book> {
        logger.info("Can not be possible to get books")
        return listOf()
    }

    override fun insertBook(book: Book): Book {
        logger.info("Can not be possible to insert book $book")
        return Book()
    }
}