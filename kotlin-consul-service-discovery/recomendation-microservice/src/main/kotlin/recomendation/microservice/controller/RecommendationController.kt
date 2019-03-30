package recomendation.microservice.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import recomendation.microservice.client.bookcatalogue.CatalogueOperations
import recomendation.microservice.client.bookinventory.InventoryOperations
import recomendation.microservice.model.BookRecommendation

@Controller("/api/{api.version: v1}/books")
class RecommendationController(private val catalogueOperations: CatalogueOperations,
                               private val inventoryOperations: InventoryOperations) {

    @Get("/withStock")
    fun index(): List<BookRecommendation> {
        return catalogueOperations.findAll()
                .filter { book -> inventoryOperations.hasStock(book.isbn) }
                .map { book -> BookRecommendation(book.name)}
    }


}