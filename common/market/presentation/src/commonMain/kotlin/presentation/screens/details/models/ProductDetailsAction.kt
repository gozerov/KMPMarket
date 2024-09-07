package presentation.screens.details.models

sealed interface ProductDetailsAction {

    data class ShowError(val message: String) : ProductDetailsAction

}