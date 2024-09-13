package domain.usecases

import domain.repositories.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class GetUsersUseCase(
    private val usersRepository: UsersRepository
) {

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        return@withContext usersRepository.getUsers()
    }

}