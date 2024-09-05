package presentation.screens.login

import com.adeo.kviewmodel.BaseSharedViewModel
import di.Injector
import domain.usecases.LoginUseCase
import kotlinx.coroutines.launch
import presentation.screens.login.models.LoginAction
import presentation.screens.login.models.LoginEvent
import presentation.screens.login.models.LoginState
import utils.runCatchingNonCancellation

class LoginViewModel : BaseSharedViewModel<LoginState, LoginAction, LoginEvent>(LoginState()) {

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
                    runCatchingNonCancellation {
                        loginUseCase.invoke(
                            email = viewState.emailState,
                            password = viewState.passwordState
                        )
                    }
                        .onSuccess { result ->
                            result
                                .onSuccess {
                                    viewAction = LoginAction.PerformNavigationToFeature
                                }
                                .onFailure { e ->
                                    viewAction = LoginAction.ShowError(e.message.toString())
                                }
                        }
                        .onFailure { e ->
                            viewAction = LoginAction.ShowError(e.message.toString())
                        }
                }

                is LoginEvent.NavigateToRegister -> {
                    viewAction = LoginAction.PerformNavigationToRegister
                }
            }
        }
    }

}