package domain.models

data class Product(
    val id: Int,
    val title: String,
    val brand: String,
    val price: Double,
    val rating: Double,
    val stockCount: Int,
    val image: String?
)
