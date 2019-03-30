package inventory.microservice.controller

import com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER
import inventory.microservice.model.BookInventory
import inventory.microservice.service.InventoryService
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
    fun hasStock(@NotBlank isbn: String): Boolean {
        logger.info("Running on port ${embeddedServer.port}")
        return inventoryService.getStockFromIsbn(isbn)
    }

    @Patch("/stock/{isbn}")
    fun addStock(@NotBlank isbn: String, @NotEmpty stockToAdd: Int): BookInventory {
        logger.info("Running on port ${embeddedServer.port}")
        return inventoryService.insertStockToBook(isbn, stockToAdd)
    }
}