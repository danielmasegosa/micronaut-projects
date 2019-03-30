package recomendation.microservice.model

data class BookInventory(val isbn: String, val stock: Int){
    constructor() : this("", 0)
}