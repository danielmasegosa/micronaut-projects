package recomendation.microservice.client.bookcatalogue

import catalogue.microservice.model.Book
import io.reactivex.Flowable

interface CatalogueOperations {

    fun findAll(): List<Book>

    fun insertBook(book: Book): Book
}