package data.remote

import data.models.AuthResponseBody
import data.models.LoginRequestBody
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.util.InternalAPI
import ktor.KtorService

class LoginRemoteImpl(
    private val ktorService: KtorService
) : LoginRemote {

    override suspend fun login(email: String, password: String): Boolean {
        val response = ktorService.client.post(urlString = BASE_URL) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(LoginRequestBody(email, password))
        }
        val authData: AuthResponseBody = response.body()
        println(authData)
        return true
    }

    override suspend fun register(email: String, password: String): Boolean {
        return true
    }

    companion object {

        private const val BASE_URL = "https://dummyjson.com/user/login"

    }

}