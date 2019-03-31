package recomendation.microservice.client.bookinventory

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch
import io.micronaut.http.client.annotation.Client
import recomendation.microservice.model.BookInventory
import javax.validation.constraints.NotBlank

@Client(id = "bookinventory")
interface InventoryClient: InventoryOperations {

    @Get("/books/stock/{isbn}")
    override fun hasStock(@NotBlank isbn: String): Int

    @Patch("/books/stock/{isbn}")
    override fun addStock(isbn: String, stockToAdd: Int): BookInventory
}