package data.repositories

import data.models.toFullProduct
import data.models.toProduct
import data.remote.MarketRemote
import domain.models.FullProduct
import domain.models.Product
import domain.repositories.MarketRepository

class MarketRepositoryImpl(
    private val marketRemote: MarketRemote
) : MarketRepository {

    override suspend fun getProducts(): List<Product> =
        marketRemote.getProducts().map { dto -> dto.toProduct() }

    override suspend fun getProductDetails(id: Int): FullProduct =
        marketRemote.getProductDetails(id).toFullProduct()

}