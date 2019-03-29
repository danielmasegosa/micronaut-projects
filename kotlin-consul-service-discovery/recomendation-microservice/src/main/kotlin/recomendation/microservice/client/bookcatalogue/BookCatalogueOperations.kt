package recomendation.microservice.client.bookcatalogue

import catalogue.microservice.model.Book
import io.reactivex.Flowable

interface BookCatalogueOperations {
    fun findAll(): Flowable<Book>
}