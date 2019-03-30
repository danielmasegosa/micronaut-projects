package recomendation.microservice.client.bookcatalogue

import catalogue.microservice.model.Book
import io.micronaut.retry.annotation.Fallback

@Fallback
class CatalogueClientStub: CatalogueOperations {

    override fun findAll(): List<Book> {
        val buildingMicroservices = Book("1491950358", "Building Microservices")
        val releaseIt = Book("1680502395", "Release It!")
        return listOf(buildingMicroservices, releaseIt)
    }

    override fun insertBook(book: Book): Book {
        TODO("not implemented")
    }
}