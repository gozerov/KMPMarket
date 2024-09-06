package data.remote

import data.models.AuthResponseBody

interface LoginRemote {

    suspend fun login(email: String, password: String): Result<AuthResponseBody>

    suspend fun register(email: String, password: String): Result<AuthResponseBody>

}