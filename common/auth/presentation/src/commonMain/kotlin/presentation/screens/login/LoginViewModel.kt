package presentation.screens.login

import com.adeo.kviewmodel.BaseSharedViewModel
import di.Injector
import domain.usecases.LoginUseCase
import kotlinx.coroutines.launch
import presentation.screens.login.models.LoginAction
import presentation.screens.login.models.LoginEvent
import presentation.screens.login.models.LoginState

class LoginViewModel: BaseSharedViewModel<LoginState, LoginAction, LoginEvent>(LoginState()) {

    private val loginUseCase: LoginUseCase = Injector.instance()

    override fun obtainEvent(viewEvent: LoginEvent) {
        viewModelScope.launch {
            when (viewEvent) {
                is LoginEvent.UpdateEmail -> {
                    viewState = viewState.copy(emailState = viewEvent.email)
                }

                is LoginEvent.UpdatePassword -> {
                    viewState = viewState.copy(passwordState = viewEvent.password)
                }

                is LoginEvent.NavigateToFeature -> {
                    loginUseCase.invoke(
                        email = viewState.emailState,
                        password = viewState.passwordState
                    )
                    viewAction = LoginAction.PerformNavigationToFeature
                }

                is LoginEvent.NavigateToRegister -> {
                    viewAction = LoginAction.PerformNavigationToRegister
                }
            }
        }
    }

}