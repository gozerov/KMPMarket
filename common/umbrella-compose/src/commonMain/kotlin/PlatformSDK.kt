import data.di.loginDataModule
import data.di.marketDataModule
import data.di.usersModule
import di.Injector
import di.coreModule
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.direct

object PlatformSDK {

    fun init(
        platformConfiguration: PlatformConfiguration
    ) {
        val umbrellaModule = DI.Module(
            name = "umbrella",
            init = {
                bindSingleton<PlatformConfiguration> { platformConfiguration }
            }
        )

        Injector.createDependencies(
            DI {
                importAll(
                    umbrellaModule,
                    coreModule,
                    loginDataModule,
                    marketDataModule,
                    usersModule
                )
            }.direct
        )
    }

}