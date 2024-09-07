package data.models

import kotlinx.serialization.Serializable

@Serializable
data class FullProductDTO(
    val id: Int,
    val title: String,
    val description: String,
    val brand: String? = null,
    val category: String,
    val price: Double,
    val rating: Double,
    val stock: Int,
    val images: List<String>
)
