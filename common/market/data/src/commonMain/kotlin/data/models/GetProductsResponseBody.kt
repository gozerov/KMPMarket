package data.models

import kotlinx.serialization.Serializable

@Serializable
data class GetProductsResponseBody(
    val products: List<ProductDTO>,
    val total: Int,
    val limit: Int
)
