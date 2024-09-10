package domain.models

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val birthday: String,
    val address: Address,
    val image: String?
)
