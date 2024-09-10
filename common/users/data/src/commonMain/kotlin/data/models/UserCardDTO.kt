package data.models

import kotlinx.serialization.Serializable

@Serializable
data class UserCardDTO(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val image: String? = null
)
