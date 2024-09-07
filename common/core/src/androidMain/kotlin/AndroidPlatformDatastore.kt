import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import di.Injector.instance
import okio.Path.Companion.toPath

actual fun createDataStore(): DataStore<Preferences> {
    val configuration: PlatformConfiguration = instance()
    val path = configuration.context.filesDir.resolve(dataStoreFileName).absolutePath.toPath()
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { path }
    )
}