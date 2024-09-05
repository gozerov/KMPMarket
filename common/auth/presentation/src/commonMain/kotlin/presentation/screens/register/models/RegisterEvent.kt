package presentation.screens.register.models

sealed interface RegisterEvent {

    class UpdateEmail(val email: String) : RegisterEvent

    class UpdatePassword(val password: String) : RegisterEvent

    data object NavigateToTabs : RegisterEvent

}