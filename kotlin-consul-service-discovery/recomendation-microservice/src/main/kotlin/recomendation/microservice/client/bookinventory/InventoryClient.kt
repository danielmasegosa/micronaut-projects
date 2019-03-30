package recomendation.microservice.client.bookinventory

import catalogue.microservice.model.Book
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch
import io.micronaut.http.client.annotation.Client
import javax.validation.constraints.NotBlank

@Client(id = "bookinventory")
interface InventoryClient: InventoryOperations {

    @Get("/books/stock/{isbn}")
    override fun hasStock(@NotBlank isbn: String): Boolean

    @Patch("/books/stock/{isbn}")
    override fun addStock(isbn: String, stockToAdd: Int): Book
}