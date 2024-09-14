package presentation.screens.register

import androidx.lifecycle.viewModelScope
import di.Injector
import domain.usecases.LoginUseCase
import kotlinx.coroutines.launch
import presentation.screens.register.models.RegisterAction
import presentation.screens.register.models.RegisterEvent
import presentation.screens.register.models.RegisterState
import utils.runCatchingNonCancellation
import viewmodel.BaseViewModel

class RegisterViewModel :
    BaseViewModel<RegisterState, RegisterAction, RegisterEvent>(RegisterState()) {

    private val loginUseCase = Injector.instance<LoginUseCase>()

    override fun obtainEvent(viewEvent: RegisterEvent) {
        viewModelScope.launch {
            when (viewEvent) {
                is RegisterEvent.UpdateEmail -> {
                    viewState = viewState.copy(email = viewEvent.email)
                }

                is RegisterEvent.UpdatePassword -> {
                    viewState = viewState.copy(password = viewEvent.password)
                }

                is RegisterEvent.NavigateToTabs -> {
                    runCatchingNonCancellation {
                        loginUseCase.invoke(
                            email = viewState.email,
                            password = viewState.password
                        )
                    }
                        .onSuccess { result ->
                            result
                                .onSuccess {
                                    viewAction = RegisterAction.PerformNavigationToTabs
                                }
                                .onFailure { e ->
                                    viewAction = RegisterAction.ShowError(e.message.toString())
                                }
                        }
                        .onFailure { e ->
                            viewAction = RegisterAction.ShowError(e.message.toString())
                        }
                }
            }
        }
    }

}