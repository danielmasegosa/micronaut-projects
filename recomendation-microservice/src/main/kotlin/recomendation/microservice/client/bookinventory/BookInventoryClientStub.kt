package recomendation.microservice.client.bookinventory

import io.micronaut.retry.annotation.Fallback
import io.reactivex.Maybe
import javax.inject.Singleton
import javax.validation.constraints.NotBlank

@Fallback
@Singleton
class BookInventoryClientStub: BookInventoryOperations {

    override fun stock(@NotBlank isbn: String): Maybe<Boolean> {
        if (isbn == "1491950358") {
            return Maybe.just(java.lang.Boolean.TRUE)

        } else if (isbn == "1680502395") {
            return Maybe.just(java.lang.Boolean.FALSE)
        }
        return Maybe.empty()
    }
}