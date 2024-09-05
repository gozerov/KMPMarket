package domain.usecases

import domain.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class LoginUseCase(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(email: String, password: String) = withContext(Dispatchers.IO) {
        return@withContext loginRepository.login(email, password)
    }

}