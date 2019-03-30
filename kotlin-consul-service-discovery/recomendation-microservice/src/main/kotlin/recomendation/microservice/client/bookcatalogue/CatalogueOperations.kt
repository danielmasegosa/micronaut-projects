package recomendation.microservice.client.bookcatalogue

import catalogue.microservice.model.Book

interface CatalogueOperations {

    fun findAll(): List<Book>

    fun insertBook(book: Book): Book
}