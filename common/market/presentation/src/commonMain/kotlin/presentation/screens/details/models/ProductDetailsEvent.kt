package presentation.screens.details.models

sealed interface ProductDetailsEvent {

    data class LoadProduct(val id: Int) : ProductDetailsEvent

}