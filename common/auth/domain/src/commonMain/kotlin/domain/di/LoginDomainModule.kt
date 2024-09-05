package domain.di

import domain.usecases.LoginUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory
import org.kodein.di.instance

val loginDomainModule = DI.Module("loginDomainModule") {
    bind<LoginUseCase>() with factory { LoginUseCase(instance()) }
}