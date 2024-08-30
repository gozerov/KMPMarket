package data.remote

interface LoginRemote {

    suspend fun login(email: String, password: String): Boolean

    suspend fun register(email: String, password: String): Boolean

}