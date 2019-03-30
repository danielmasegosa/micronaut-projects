package recomendation.microservice.client.bookinventory

import recomendation.microservice.model.BookInventory
import javax.validation.constraints.NotBlank

interface InventoryOperations {

    fun hasStock(@NotBlank isbn: String): Boolean
    fun addStock(@NotBlank isbn: String, @NotBlank stockToAdd: Int): BookInventory
}