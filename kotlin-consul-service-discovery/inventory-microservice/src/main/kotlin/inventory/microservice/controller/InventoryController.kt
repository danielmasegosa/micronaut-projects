package inventory.microservice.controller

import inventory.microservice.model.BookInventory
import inventory.microservice.service.InventoryService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Validated
@Controller("/books")
class InventoryController(val inventoryService: InventoryService,
                          val embeddedServer: EmbeddedServer) {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Get("/stock/{isbn}")
    fun hasStock(@NotBlank isbn: String): HttpResponse<Int> {
        logger.info("Running on port ${embeddedServer.port}")

        val stockFromIsbn = inventoryService.getStockFromIsbn(isbn)

        return if (stockFromIsbn == null) {
                    HttpResponse.notFound()
                } else {
                    HttpResponse.ok(stockFromIsbn)
        }
    }

    @Patch("/stock/{isbn}")
    fun addStock(@NotBlank isbn: String, @NotEmpty stockToAdd: Int): HttpResponse<BookInventory> {
        logger.info("Running on port ${embeddedServer.port}")
        val insertedStockToBook = inventoryService.insertStockToBook(isbn, stockToAdd)
        return if (insertedStockToBook == null) {
            HttpResponse.notFound()
        } else {
            HttpResponse.ok(insertedStockToBook)
        }
    }
}