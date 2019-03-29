package recomendation.microservice

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("recomendation.microservice")
                .mainClass(Application.javaClass)
                .start()
    }
}