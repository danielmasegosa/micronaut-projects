package inventory.microservice.controller

import inventory.microservice.BookInventory
import inventory.microservice.service.InventoryService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.constraints.NotBlank

@Validated
@Controller("/books")
class BooksController(val inventoryService: InventoryService,
                      val embeddedServer: EmbeddedServer) {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/stock/{isbn}")
    fun stock(@NotBlank isbn: String): Boolean? {
        return inventoryService.getStockFromIsbn(isbn)
    }

    @Post("/stock/{isbn}")
    private fun bookInventoryByIsbn(isbn: String, stockToAdd: Int): BookInventory {
        return inventoryService.insertStockToBook(isbn, stockToAdd)
    }
}