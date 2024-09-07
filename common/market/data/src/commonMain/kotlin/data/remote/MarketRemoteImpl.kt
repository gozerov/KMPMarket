package data.remote

import data.models.FullProductDTO
import data.models.GetProductsResponseBody
import data.models.ProductDTO
import io.ktor.client.call.body
import io.ktor.client.request.get
import ktor.KtorService

class MarketRemoteImpl(
    private val ktorService: KtorService
) : MarketRemote {

    override suspend fun getProducts(): List<ProductDTO> {
        val response = ktorService.client.get(urlString = BASE_URL)
        if (response.status.value >= 400)
            throw Exception(response.status.description)

        val data: GetProductsResponseBody = response.body()
        return data.products
    }

    override suspend fun getProductDetails(id: Int): FullProductDTO {
        val response = ktorService.client.get(urlString = "$BASE_URL/$id")
        if (response.status.value >= 400)
            throw Exception(response.status.description)

        val data: FullProductDTO = response.body()
        return data
    }

    companion object {

        private const val BASE_URL = "https://dummyjson.com/products"

    }

}