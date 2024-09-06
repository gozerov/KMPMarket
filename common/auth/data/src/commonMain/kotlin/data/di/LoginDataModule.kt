package data.di

import data.remote.LoginRemote
import data.remote.LoginRemoteImpl
import data.repositories.LoginRepositoryImpl
import domain.repository.LoginRepository
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val loginDataModule = DI.Module("loginDataModule") {
    bindSingleton<LoginRemote> { LoginRemoteImpl(instance()) }
    bindSingleton<LoginRepository> { LoginRepositoryImpl(instance(), instance()) }
}