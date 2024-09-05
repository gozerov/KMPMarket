package domain.repository

interface LoginRepository {

    suspend fun login(email: String, password: String): Result<String>

    suspend fun register(email: String, password: String): Result<String>

}