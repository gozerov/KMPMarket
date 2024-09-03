package presentation.screens.login.models

sealed interface LoginEvent {

    class UpdatePassword(val password: String) : LoginEvent

    class UpdateEmail(val email: String) : LoginEvent

    data object NavigateToFeature : LoginEvent

    data object NavigateToRegister : LoginEvent

}