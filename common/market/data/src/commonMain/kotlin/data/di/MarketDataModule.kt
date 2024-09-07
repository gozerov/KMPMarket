package data.di

import data.remote.MarketRemote
import data.remote.MarketRemoteImpl
import data.repositories.MarketRepositoryImpl
import domain.repositories.MarketRepository
import domain.usecases.GetProductDetailsUseCase
import domain.usecases.GetProductsUseCase
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val marketDataModule = DI.Module("marketDataModule") {
    bindSingleton<MarketRemote> { MarketRemoteImpl(instance()) }
    bindSingleton<MarketRepository> { MarketRepositoryImpl(instance()) }

    bindProvider<GetProductsUseCase> { GetProductsUseCase(instance()) }
    bindProvider<GetProductDetailsUseCase> { GetProductDetailsUseCase(instance()) }
}