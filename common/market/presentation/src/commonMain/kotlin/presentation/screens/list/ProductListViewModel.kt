package presentation.screens.list

import com.adeo.kviewmodel.BaseSharedViewModel
import di.Injector
import domain.usecases.GetProductsUseCase
import kotlinx.coroutines.launch
import presentation.screens.list.models.ProductListAction
import presentation.screens.list.models.ProductListEvent
import presentation.screens.list.models.ProductListState
import utils.runCatchingNonCancellation

class ProductListViewModel :
    BaseSharedViewModel<ProductListState, ProductListAction, ProductListEvent>(ProductListState()) {

    private val getProductsUseCase: GetProductsUseCase = Injector.instance()

    override fun obtainEvent(viewEvent: ProductListEvent) {
        viewModelScope.launch {
            when (viewEvent) {
                is ProductListEvent.LoadProducts -> {
                    runCatchingNonCancellation {
                        getProductsUseCase.invoke()
                    }
                        .onSuccess { products ->
                            viewState = viewState.copy(products = products)
                        }
                        .onFailure { e ->
                            viewAction = ProductListAction.ShowError(e.message.toString())
                        }
                }

                is ProductListEvent.NavigateToDetails -> {
                    viewAction = ProductListAction.PerformNavigationToDetails(viewEvent.id)
                }
            }
        }
    }

}