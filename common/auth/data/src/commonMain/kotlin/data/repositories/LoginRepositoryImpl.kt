package data.repositories

import data.remote.LoginRemote
import domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val loginRemote: LoginRemote
): LoginRepository {

    override suspend fun login(email: String, password: String): Result<String> {
        return loginRemote.login(email, password)
    }

    override suspend fun register(email: String, password: String): Result<String> {
        return loginRemote.register(email, password)
    }

}