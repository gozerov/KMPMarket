package presentation.screens.list.models

sealed interface ProductListEvent {

    data object LoadProducts : ProductListEvent

    data class NavigateToDetails(val id: Int) : ProductListEvent

}