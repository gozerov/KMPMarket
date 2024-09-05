package di

import data.di.loginDataModule
import domain.di.loginDomainModule
import org.kodein.di.DI

val umbrellaModule = DI.Module("umbrellaModule") {
    importAll(
        coreModule,
        loginDataModule,
        loginDomainModule
    )
}