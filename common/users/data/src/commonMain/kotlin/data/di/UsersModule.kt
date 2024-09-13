package data.di

import data.remote.UsersRemote
import data.remote.UsersRemoteImpl
import data.repositories.UsersRepositoryImpl
import domain.repositories.UsersRepository
import domain.usecases.GetUserUseCase
import domain.usecases.GetUsersUseCase
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val usersModule = DI.Module("usersModule") {

    bindSingleton<UsersRemote> { UsersRemoteImpl(instance()) }
    bindSingleton<UsersRepository> { UsersRepositoryImpl(instance()) }

    bindProvider<GetUsersUseCase> { GetUsersUseCase(instance()) }
    bindProvider<GetUserUseCase> { GetUserUseCase(instance()) }

}