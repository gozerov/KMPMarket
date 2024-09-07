package domain.usecases

import domain.models.FullProduct
import domain.repositories.MarketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class GetProductDetailsUseCase(
    private val marketRepository: MarketRepository
) {

    suspend operator fun invoke(id: Int): FullProduct = withContext(Dispatchers.IO) {
        return@withContext marketRepository.getProductDetails(id)
    }

}