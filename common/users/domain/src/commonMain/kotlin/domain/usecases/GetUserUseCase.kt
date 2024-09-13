package domain.usecases

import domain.repositories.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class GetUserUseCase(
    private val usersRepository: UsersRepository
) {

    suspend operator fun invoke(id: Int) = withContext(Dispatchers.IO) {
        return@withContext usersRepository.getUser(id)
    }

}