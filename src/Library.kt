import kotlin.time.Duration

class Library<T>(val items: MutableList<T> = mutableListOf()) {
    fun addItem(item: T) = items.add(item)
    fun getAllItems(): List<T> = items
}

data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)

data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)

data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)

sealed class LibraryItem {
    data class BookItem(val book: Book): LibraryItem()
    data class MagazineItem(val magazine: Magazine): LibraryItem()
    data class DVDItem(val dvd: DVD): LibraryItem()
}

fun filterByYear(items: List<LibraryItem>, year: Int): List<LibraryItem> {
    return items.filter { item ->
        when (item) {
            is LibraryItem.BookItem -> item.book.year == year
            else -> false
        }
    }
}

fun sortByTitle(items: List<LibraryItem>): List<LibraryItem> {
    return items.sortedBy { item ->
        when (item) {
            is LibraryItem.BookItem -> item.book.title
            is LibraryItem.MagazineItem -> item.magazine.title
            is LibraryItem.DVDItem -> item.dvd.title
        }
    }
}

fun groupByAuthor(items: List<LibraryItem>): Map<String, List<LibraryItem>> {
    return items.filterIsInstance<LibraryItem.BookItem>()
        .groupBy{ it.book.author }
}

fun calculateTotalDuration(items: List<LibraryItem>): Int {
    return items.filterIsInstance<LibraryItem.DVDItem>()
        .sumOf{ it.dvd.duration }
}

fun main() {
    val book = Book("Грокаем Алгоритмы", "Адитья Бхаргава ", 2024, "12345")
    val magazine = Magazine("Розовые слоники", 123, "Ноябрь")
    val dvd = DVD("Цикада 3301", "Алана Ричсона", 105)

    val items = listOf(
        LibraryItem.BookItem(book),
        LibraryItem.MagazineItem(magazine),
        LibraryItem.DVDItem(dvd)
    )

    val library = Library<LibraryItem>()
    items.forEach { library.addItem(it) }

    println("Все элементы: ${library.getAllItems().size}")
    println("Фильтр по году 2024: ${filterByYear(items,2024).size}")
    println("Отсортировано по названию: ${sortByTitle(items).map { 
        when (it) {
            is LibraryItem.BookItem -> it.book.title
            is LibraryItem.MagazineItem -> it.magazine.title
            is LibraryItem.DVDItem -> it.dvd.title
        }
    }}")

    println("Группировка по автору: ${groupByAuthor(items)}")
    println("Общая продолжительность DVD: ${calculateTotalDuration(items)} мин")
}