package analytics.service

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("analytics.service")
                .mainClass(Application.javaClass)
                .start()
    }
}