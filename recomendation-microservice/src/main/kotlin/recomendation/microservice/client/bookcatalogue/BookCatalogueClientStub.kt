package recomendation.microservice.client.bookcatalogue

import catalogue.microservice.model.Book
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Flowable
import javax.inject.Singleton

@Fallback
@Singleton
class BookCatalogueClientStub: BookCatalogueOperations {

    override fun findAll(): Flowable<Book> {
        val buildingMicroservices = Book("1491950358", "Building Microservices")
        val releaseIt = Book("1680502395", "Release It!")
        return Flowable.just(buildingMicroservices, releaseIt)
    }
}