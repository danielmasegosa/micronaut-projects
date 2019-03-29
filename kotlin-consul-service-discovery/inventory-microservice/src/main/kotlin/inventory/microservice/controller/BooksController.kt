package inventory.microservice.controller

import inventory.microservice.BookInventory
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.constraints.NotBlank

@Validated
@Controller("/books")
class BooksController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/stock/{isbn}")
    fun stock(@NotBlank isbn: String): Boolean? {
        return bookInventoryByIsbn(isbn).map { (_, stock) -> stock > 0 }.orElse(null)
    }

    private fun bookInventoryByIsbn(isbn: String): Optional<BookInventory> {
        return when (isbn) {
            ("1491950358") -> Optional.of(BookInventory(isbn, 4))
            ("1680502395") -> Optional.of(BookInventory(isbn, 1))
            else -> Optional.empty()
        }
    }
}