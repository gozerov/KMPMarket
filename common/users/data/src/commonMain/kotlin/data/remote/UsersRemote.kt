package data.remote

import data.models.UserCardDTO
import data.models.UserDTO

interface UsersRemote {

    suspend fun getUsers(): List<UserCardDTO>

    suspend fun getUser(id: Int): UserDTO

}