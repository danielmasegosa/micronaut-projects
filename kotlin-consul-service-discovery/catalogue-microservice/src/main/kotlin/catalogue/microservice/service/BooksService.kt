package catalogue.microservice.service

import catalogue.microservice.model.Book

interface BooksService {
    fun findAllBooks(): List<Book>

    fun insertBook(book: Book): Book
}