package domain.repositories

import domain.models.FullProduct
import domain.models.Product

interface MarketRepository {

    suspend fun getProducts(): List<Product>

    suspend fun getProductDetails(id: Int): FullProduct

}