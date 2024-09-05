package data.remote

interface LoginRemote {

    suspend fun login(email: String, password: String): Result<String>

    suspend fun register(email: String, password: String): Result<String>

}