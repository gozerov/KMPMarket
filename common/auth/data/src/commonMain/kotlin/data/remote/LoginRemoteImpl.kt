package data.remote

class LoginRemoteImpl : LoginRemote {

    override suspend fun login(email: String, password: String): Boolean {
        return true
    }

    override suspend fun register(email: String, password: String): Boolean {
        return true
    }

}