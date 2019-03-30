package inventory.microservice.service.impl

import inventory.microservice.model.BookInventory
import inventory.microservice.service.InventoryService
import java.util.*
import javax.inject.Singleton

@Singleton
class InventoryServiceImpl: InventoryService {

    private val inventory = mutableListOf(
        BookInventory("1491950358", 0),
        BookInventory("1680502395", 0))

    override fun getStockFromIsbn(isbn: String): Boolean {

        val filter: List<BookInventory> = inventory.filter { it.isbn == isbn }
        val optional = when {
            filter.isNotEmpty() -> Optional.of(filter[0])
            else -> Optional.empty()
        }

        return optional.map { it.stock > 0 }.orElse(false)
    }

    override fun insertStockToBook(isbn: String, newStock: Int): BookInventory {
        val updatedBookInventory = inventory
            .filter { bookInventory -> bookInventory.isbn == isbn }
            .map { it.copy(isbn = it.isbn, stock = it.stock + newStock) }[0]

        val removeIf: Boolean = inventory.removeIf { it.isbn == isbn }

        if(removeIf) {
            inventory.add(updatedBookInventory)
        }

        return updatedBookInventory
    }
}