package catalogue.microservice.service.impl

import catalogue.microservice.model.Book
import catalogue.microservice.service.BooksService
import javax.inject.Singleton

@Singleton
class BooksServiceImpl: BooksService {

    private var booksList = mutableListOf(
        Book("1491950358", "Building Microservices"),
        Book("1680502395", "Release It"),
        Book("0321601912", "Continous Delivery"))

    override fun findAllBooks(): List<Book> {
        return booksList
    }

    override fun insertBook(book: Book): Book {
        booksList.add(book)
        return book
    }
}
