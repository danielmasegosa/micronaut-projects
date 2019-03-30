package inventory.microservice.service

import inventory.microservice.model.BookInventory

interface InventoryService {

    fun getStockFromIsbn(isbn: String): Boolean

    fun insertStockToBook(isbn: String, newStock: Int): BookInventory
}