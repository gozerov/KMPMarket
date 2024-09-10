package data.models

import kotlinx.serialization.Serializable

@Serializable
data class GetUsersResponseBody(
    val users: List<UserCardDTO>
)
