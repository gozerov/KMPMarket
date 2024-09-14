package presentation.screens.list

import androidx.lifecycle.viewModelScope
import di.Injector
import domain.usecases.GetUsersUseCase
import kotlinx.coroutines.launch
import presentation.screens.list.models.UserListAction
import presentation.screens.list.models.UserListEvent
import presentation.screens.list.models.UserListState
import utils.runCatchingNonCancellation
import viewmodel.BaseViewModel

class UserListViewModel : BaseViewModel<UserListState, UserListAction, UserListEvent>(
    UserListState()
) {

    private val getUsersUseCase = Injector.instance<GetUsersUseCase>()

    override fun obtainEvent(viewEvent: UserListEvent) {
        viewModelScope.launch {
            when (viewEvent) {
                is UserListEvent.LoadUsers -> {
                    runCatchingNonCancellation {
                        getUsersUseCase.invoke()
                    }
                        .onSuccess { res ->
                            viewState = viewState.copy(users = res)
                        }
                        .onFailure { e ->
                            viewAction = UserListAction.ShowError(e.message.toString())
                        }
                }

                is UserListEvent.NavigateToDetails -> {
                    viewAction = UserListAction.PerformNavigationToDetails(viewEvent.id)
                }
            }
        }
    }

}