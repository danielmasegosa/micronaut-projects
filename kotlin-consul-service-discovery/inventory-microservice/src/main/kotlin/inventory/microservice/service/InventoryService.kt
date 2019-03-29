package inventory.microservice.service

import inventory.microservice.BookInventory
import java.util.*

interface InventoryService {

    fun getStockFromIsbn(isbn: String): Boolean?

    fun insertStockToBook(isbn: String, newStock: Int): BookInventory
}