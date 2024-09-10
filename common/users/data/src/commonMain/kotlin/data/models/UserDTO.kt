package data.models

data class UserDTO(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val birthday: String,
    val address: AddressDTO,
    val image: String? = null
)
