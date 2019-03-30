package recomendation.microservice.client.bookinventory

import catalogue.microservice.model.Book
import io.reactivex.Maybe
import javax.validation.constraints.NotBlank

interface InventoryOperations {

    fun hasStock(@NotBlank isbn: String): Boolean
    fun addStock(@NotBlank isbn: String, @NotBlank stockToAdd: Int): Book
}