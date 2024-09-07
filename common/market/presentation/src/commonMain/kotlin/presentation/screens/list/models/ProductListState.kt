package presentation.screens.list.models

import domain.models.Product

data class ProductListState(
    val products: List<Product> = emptyList()
)
