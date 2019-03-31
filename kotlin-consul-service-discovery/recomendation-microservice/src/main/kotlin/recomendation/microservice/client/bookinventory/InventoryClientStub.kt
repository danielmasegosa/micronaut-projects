package recomendation.microservice.client.bookinventory

import io.micronaut.http.HttpResponse
import io.micronaut.retry.annotation.Fallback
import org.slf4j.LoggerFactory
import recomendation.microservice.model.BookInventory
import javax.validation.constraints.NotBlank

@Fallback
class InventoryClientStub: InventoryOperations {

    private val logger = LoggerFactory.getLogger(this.javaClass)


    override fun hasStock(@NotBlank isbn: String): HttpResponse<Int> {
        logger.info("Error at get stock for book with ISBN: $isbn")
        return HttpResponse.serverError()
    }

    override fun addStock(isbn: String, stockToAdd: Int): BookInventory {
        logger.info("Error at add stock in $isbn book")
        return BookInventory()
    }
}