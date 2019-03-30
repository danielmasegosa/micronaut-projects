package catalogue.microservice.model

data class Book(val isbn: String, val name: String){
    constructor(): this("", "")
}