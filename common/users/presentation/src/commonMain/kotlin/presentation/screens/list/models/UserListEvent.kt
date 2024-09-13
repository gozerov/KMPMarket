package presentation.screens.list.models

sealed interface UserListEvent {

    data object LoadUsers : UserListEvent

    data class NavigateToDetails(val id: Int) : UserListEvent

}