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

    override fun getStockFromIsbn(isbn: String): Int? {

        val bookInventory: List<BookInventory> = inventory.filter { it.isbn == isbn }

        return when {
            bookInventory.isNotEmpty() -> bookInventory[0].stock
            else -> null
        }
    }

    override fun insertStockToBook(isbn: String, newStock: Int): BookInventory? {

        val filteredBooksInventory = inventory
            .filter { bookInventory -> bookInventory.isbn == isbn }

        return when {
            filteredBooksInventory.isNotEmpty() -> {
                val updatedBookInventory = filteredBooksInventory.map { it.copy(isbn = isbn, stock = it.stock + newStock) }[0]
                val removeIf: Boolean = inventory.removeIf { it.isbn == isbn }

                if(removeIf) {
                    inventory.add(updatedBookInventory)
                }
                return updatedBookInventory
            }
            else -> null
        }
    }
}