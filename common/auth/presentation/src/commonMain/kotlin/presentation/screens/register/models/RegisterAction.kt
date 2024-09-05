package presentation.screens.register.models

sealed interface RegisterAction {

    data object None : RegisterAction

    data object PerformNavigationToTabs : RegisterAction

    data class ShowError(
        val message: String
    ) : RegisterAction

}