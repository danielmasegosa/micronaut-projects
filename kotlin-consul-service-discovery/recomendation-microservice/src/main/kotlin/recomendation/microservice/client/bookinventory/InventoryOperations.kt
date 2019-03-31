package recomendation.microservice.client.bookinventory

import io.micronaut.http.HttpResponse
import recomendation.microservice.model.BookInventory
import javax.validation.constraints.NotBlank

interface InventoryOperations {

    fun hasStock(@NotBlank isbn: String): HttpResponse<Int>
    fun addStock(@NotBlank isbn: String, @NotBlank stockToAdd: Int): BookInventory
}