package data.models

import kotlinx.serialization.Serializable

@Serializable
data class AddressDTO(
    val city: String,
    val country: String
)
