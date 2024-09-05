package data.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseBody(
    val token: String,
    val refreshToken: String
)