package data.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductDTO(
    val id: Int,
    val title: String,
    val brand: String? = null,
    val price: Double,
    val rating: Double,
    val stock: Int,
    val images: List<String>
)
