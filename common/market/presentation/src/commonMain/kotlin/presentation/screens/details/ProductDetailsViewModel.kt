package presentation.screens.details

import androidx.lifecycle.viewModelScope
import di.Injector
import domain.usecases.GetProductDetailsUseCase
import kotlinx.coroutines.launch
import presentation.screens.details.models.ProductDetailsAction
import presentation.screens.details.models.ProductDetailsEvent
import presentation.screens.details.models.ProductDetailsState
import utils.runCatchingNonCancellation
import viewmodel.BaseViewModel

class ProductDetailsViewModel :
    BaseViewModel<ProductDetailsState, ProductDetailsAction, ProductDetailsEvent>(
        ProductDetailsState()
    ) {

    private val getProductDetailsUseCase: GetProductDetailsUseCase = Injector.instance()

    override fun obtainEvent(viewEvent: ProductDetailsEvent) {
        viewModelScope.launch {
            when (viewEvent) {
                is ProductDetailsEvent.LoadProduct -> {
                    runCatchingNonCancellation {
                        getProductDetailsUseCase.invoke(viewEvent.id)
                    }
                        .onSuccess { product ->
                            viewState = viewState.copy(product = product)
                        }
                        .onFailure { e ->
                            viewAction = ProductDetailsAction.ShowError(e.message.toString())
                        }
                }
            }
        }
    }


}