package book.service

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("book.service")
                .mainClass(Application.javaClass)
                .start()
    }
}