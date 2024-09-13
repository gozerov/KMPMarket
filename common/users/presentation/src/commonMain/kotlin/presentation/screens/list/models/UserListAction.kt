package presentation.screens.list.models

sealed interface UserListAction {

    data class ShowError(val message: String) : UserListAction

    data class PerformNavigationToDetails(val id: Int) : UserListAction

}