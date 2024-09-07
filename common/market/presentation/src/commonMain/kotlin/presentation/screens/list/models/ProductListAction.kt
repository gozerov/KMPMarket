package presentation.screens.list.models

sealed interface ProductListAction {

    data class PerformNavigationToDetails(val id: Int) : ProductListAction

    data class ShowError(val message: String) : ProductListAction

}