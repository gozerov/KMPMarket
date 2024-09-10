package data.repositories

import data.models.toUser
import data.models.toUserCard
import data.remote.UsersRemote
import domain.models.User
import domain.models.UserCard
import domain.repositories.UsersRepository

class UsersRepositoryImpl(
    private val usersRemote: UsersRemote
) : UsersRepository {

    override suspend fun getUsers(): List<UserCard> =
        usersRemote.getUsers().map { dto -> dto.toUserCard() }

    override suspend fun getUser(id: Int): User = usersRemote.getUser(id).toUser()

}