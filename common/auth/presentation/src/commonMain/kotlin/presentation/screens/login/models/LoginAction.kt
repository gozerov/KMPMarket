package presentation.screens.login.models

sealed interface LoginAction {

    data object None: LoginAction

    data object PerformNavigationToFeature: LoginAction

    data object PerformNavigationToRegister: LoginAction

}