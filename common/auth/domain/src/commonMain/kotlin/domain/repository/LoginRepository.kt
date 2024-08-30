package domain.repository

interface LoginRepository {

    suspend fun login(email: String, password: String): Boolean

    suspend fun register(email: String, password: String): Boolean

}