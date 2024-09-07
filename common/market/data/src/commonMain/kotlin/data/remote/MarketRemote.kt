package data.remote

import data.models.FullProductDTO
import data.models.ProductDTO

interface MarketRemote {

    suspend fun getProducts(): List<ProductDTO>

    suspend fun getProductDetails(id: Int): FullProductDTO

}