package di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import createDataStore
import ktor.KtorService
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val coreModule = DI.Module("coreModule") {
    bindSingleton<KtorService> { KtorService() }
    bindSingleton<DataStore<Preferences>> { createDataStore() }
}