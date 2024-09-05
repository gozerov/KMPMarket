package data.remote

import data.models.AuthResponseBody
import data.models.LoginRequestBody
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.isSuccess
import ktor.KtorService

class LoginRemoteImpl(
    private val ktorService: KtorService
) : LoginRemote {

    override suspend fun login(email: String, password: String): Result<String> {
        val response = ktorService.client.post(urlString = BASE_URL) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(LoginRequestBody(email, password))
        }
        try {
            println(response.status.value)
            if (response.status.value >= 400)
                return Result.failure(Exception(response.status.description))

            val authData: AuthResponseBody = response.body()
            return Result.success(authData.token)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun register(email: String, password: String): Result<String> {
        val response = ktorService.client.post(urlString = BASE_URL) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(LoginRequestBody(email, password))
        }
        try {
            if (response.status.value >= 400)
                return Result.failure(Exception(response.status.description))

            val authData: AuthResponseBody = response.body()
            return Result.success(authData.token)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    companion object {

        private const val BASE_URL = "https://dummyjson.com/user/login"

    }

}