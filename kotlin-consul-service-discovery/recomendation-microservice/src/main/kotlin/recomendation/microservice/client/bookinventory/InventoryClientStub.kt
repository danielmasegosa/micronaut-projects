package recomendation.microservice.client.bookinventory

import catalogue.microservice.model.Book
import io.micronaut.retry.annotation.Fallback
import javax.validation.constraints.NotBlank

@Fallback
class InventoryClientStub: InventoryOperations {

    override fun hasStock(@NotBlank isbn: String): Boolean {
//        if (isbn == "1491950358") {
//            return Maybe.just(java.lang.Boolean.TRUE)
//
//        } else if (isbn == "1680502395") {
//            return Maybe.just(java.lang.Boolean.FALSE)
//        }
//        return Maybe.empty()
        return false
    }

    override fun addStock(isbn: String, stockToAdd: Int): Book {
        TODO("not implemented")
    }
}