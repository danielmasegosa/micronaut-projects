package inventory.microservice

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("inventory.microservice")
                .mainClass(Application.javaClass)
                .start()
    }
}