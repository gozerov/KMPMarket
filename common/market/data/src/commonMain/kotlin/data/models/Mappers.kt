package data.models

import domain.models.FullProduct
import domain.models.Product

fun ProductDTO.toProduct() = Product(id, title, brand, price, rating, stock, images.firstOrNull())

fun FullProductDTO.toFullProduct() =
    FullProduct(id, title, description, brand, category, price, rating, stock, images)