package presentation.screens.list.models

import domain.models.UserCard

data class UserListState(
    val users: List<UserCard> = emptyList()
)
