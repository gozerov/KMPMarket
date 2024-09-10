package data.remote

import data.models.GetUsersResponseBody
import data.models.UserCardDTO
import data.models.UserDTO
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.parameters
import ktor.KtorService

class UsersRemoteImpl(
    private val ktorService: KtorService
) : UsersRemote {

    override suspend fun getUsers(): List<UserCardDTO> {
        val response = ktorService.client.get("$BASE_URL/search") {
            parameters {
                append("q", "")
                append("limit", "10")
            }
        }
        val users = response.body<GetUsersResponseBody>()
        return users.users
    }

    override suspend fun getUser(id: Int): UserDTO {
        val response = ktorService.client.get("$BASE_URL/$id")
        val user = response.body<UserDTO>()
        return user
    }

    companion object {

        private const val BASE_URL = "https://dummyjson.com/users"

    }

}