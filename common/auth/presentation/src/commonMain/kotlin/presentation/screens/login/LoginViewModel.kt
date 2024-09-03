package presentation.screens.login

import com.adeo.kviewmodel.BaseSharedViewModel
import presentation.screens.login.models.LoginAction
import presentation.screens.login.models.LoginEvent
import presentation.screens.login.models.LoginState

class LoginViewModel : BaseSharedViewModel<LoginState, LoginAction, LoginEvent>(LoginState()) {

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.UpdateEmail -> {
                viewState = viewState.copy(emailState = viewEvent.email)
            }

            is LoginEvent.UpdatePassword -> {
                viewState = viewState.copy(passwordState = viewEvent.password)
            }

            is LoginEvent.NavigateToFeature -> {
                viewAction = LoginAction.PerformNavigationToFeature
            }

            is LoginEvent.NavigateToRegister -> {
                viewAction = LoginAction.PerformNavigationToRegister
            }
        }
    }

}