package data.models

import domain.models.Address
import domain.models.User
import domain.models.UserCard

fun AddressDTO.toAddress() = Address(city, country)

fun UserCardDTO.toUserCard() = UserCard(id, firstName, lastName, image)

fun UserDTO.toUser() =
    User(id, firstName, lastName, username, email, birthday, address.toAddress(), image)