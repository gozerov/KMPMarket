package di

import data.di.loginModule
import org.kodein.di.DI

val umbrellaModule = DI.Module("umbrellaModule") {
    importAll(
        loginModule
    )
}