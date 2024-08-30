package data.di

import data.remote.LoginRemote
import data.remote.LoginRemoteImpl
import data.repositories.LoginRepositoryImpl
import domain.repository.LoginRepository
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val loginModule = DI.Module("loginModule") {
    bindSingleton<LoginRemote> { LoginRemoteImpl() }
    bindSingleton<LoginRepository> { LoginRepositoryImpl(instance()) }
}