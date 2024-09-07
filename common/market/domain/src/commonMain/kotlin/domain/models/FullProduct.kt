package domain.models

data class FullProduct(
    val id: Int,
    val title: String,
    val description: String,
    val brand: String?,
    val category: String,
    val price: Double,
    val rating: Double,
    val stockCount: Int,
    val images: List<String>
)
