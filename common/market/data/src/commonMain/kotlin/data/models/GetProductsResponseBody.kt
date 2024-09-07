package data.models

data class GetProductsResponseBody(
    val products: List<ProductDTO>,
    val total: Int,
    val limit: Int
)
