package recomendation.microservice.client.bookinventory

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Maybe
import javax.validation.constraints.NotBlank

@Client(id = "bookinventory")
interface BookInventoryClient: BookInventoryOperations {
    @Get("/books/stock/{isbn}")
    override fun stock(@NotBlank isbn: String): Maybe<Boolean>
}