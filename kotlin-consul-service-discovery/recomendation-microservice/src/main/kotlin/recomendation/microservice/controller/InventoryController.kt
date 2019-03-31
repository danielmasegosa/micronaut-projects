package recomendation.microservice.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch
import recomendation.microservice.client.bookinventory.InventoryOperations
import recomendation.microservice.model.BookInventory
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Controller("/api/{api.version: v1}/books")
class InventoryController(private val inventoryOperations: InventoryOperations) {

    @Get("/stock/{isbn}")
    fun getStock(@NotBlank isbn: String): Int {
        return inventoryOperations.hasStock(isbn)
    }

    @Patch("/stock/{isbn}")
    fun addStock(@NotBlank isbn: String, @NotEmpty stockToAdd: Int): BookInventory {
        return inventoryOperations.addStock(isbn, stockToAdd)
    }
}