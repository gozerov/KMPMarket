package domain.repositories

import domain.models.User
import domain.models.UserCard

interface UsersRepository {

    suspend fun getUsers(): List<UserCard>

    suspend fun getUser(id: Int): User

}