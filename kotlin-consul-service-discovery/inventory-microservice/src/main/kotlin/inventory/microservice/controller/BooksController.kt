package inventory.microservice.controller

import inventory.microservice.BookInventory
import inventory.microservice.service.InventoryService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.validation.Validated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Validated
@Controller("/books")
class BooksController(val inventoryService: InventoryService,
                      val embeddedServer: EmbeddedServer) {

    @Get("/stock/{isbn}")
    fun getStock(@NotBlank isbn: String): Boolean? {
        print(embeddedServer.port)
        return inventoryService.getStockFromIsbn(isbn)
    }

    @Post("/stock/{isbn}")
    fun addStock(@NotBlank isbn: String, @NotEmpty stockToAdd: Int): BookInventory {
        print(embeddedServer.port)
        return inventoryService.insertStockToBook(isbn, stockToAdd)
    }
}