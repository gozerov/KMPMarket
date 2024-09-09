package domain.usecases

import domain.models.Product
import domain.repositories.MarketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.withContext

class GetProductsUseCase(
    private val marketRepository: MarketRepository
) {

    suspend operator fun invoke(): List<Product> = withContext(Dispatchers.IO) {
        return@withContext marketRepository.getProducts()
    }

}