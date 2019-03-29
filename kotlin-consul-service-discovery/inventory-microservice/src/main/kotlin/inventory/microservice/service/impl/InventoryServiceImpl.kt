package inventory.microservice.service.impl

import inventory.microservice.BookInventory
import inventory.microservice.service.InventoryService
import javax.inject.Singleton

@Singleton
class InventoryServiceImpl: InventoryService {

    private val inventory = mutableListOf(
        BookInventory("1491950358", 0),
        BookInventory("1680502395", 0))

    override fun getStockFromIsbn(isbn: String): Boolean? {
        return inventory.filter { bookInventory -> bookInventory.isbn == isbn }
            .map { it.stock > 0 }.getOrNull(0)
    }

    override fun insertStockToBook(isbn: String, newStock: Int): BookInventory {
        return inventory
            .filter { bookInventory -> bookInventory.isbn == isbn }
            .map { it.copy(isbn = it.isbn, stock = it.stock + newStock) }[0]
    }
}