package data.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import data.remote.LoginRemote
import domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val loginRemote: LoginRemote,
    private val dataStore: DataStore<Preferences>
) : LoginRepository {

    override suspend fun login(email: String, password: String): Result<String> {

        val tokenKey = stringPreferencesKey(TOKEN_KEY)
        val refreshTokenKey = stringPreferencesKey(REFRESH_TOKEN_KEY)

        val res = loginRemote.login(email, password)
        return res.onSuccess { response ->
            dataStore.edit { settings ->
                settings[tokenKey] = response.token
                settings[refreshTokenKey] = response.refreshToken
            }
        }.map { r -> r.token }
    }

    override suspend fun register(email: String, password: String): Result<String> {
        val tokenKey = stringPreferencesKey(TOKEN_KEY)
        val refreshTokenKey = stringPreferencesKey(REFRESH_TOKEN_KEY)

        val res = loginRemote.login(email, password)
        return res.onSuccess { response ->
            dataStore.edit { settings ->
                settings[tokenKey] = response.token
                settings[refreshTokenKey] = response.refreshToken
            }
        }.map { r -> r.token }
    }

    companion object {

        private const val TOKEN_KEY = "tokenKey"
        private const val REFRESH_TOKEN_KEY = "refreshTokenKey"

    }

}