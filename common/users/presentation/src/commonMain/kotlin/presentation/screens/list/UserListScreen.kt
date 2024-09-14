package presentation.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.alexzhirkevich.cupertino.CupertinoText
import kotlinx.coroutines.launch
import presentation.screens.list.models.UserListAction
import presentation.screens.list.models.UserListEvent
import presentation.screens.list.views.UserCard
import ru.gozerov.kmpmarket.users.presentation.strings.UsersResStrings
import theme.KMPMarketTheme

@Composable
fun UserListScreen(viewModel: UserListViewModel = viewModel { UserListViewModel() }) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val viewState = viewModel.viewStates().collectAsState().value
    val viewAction = viewModel.viewActions().collectAsState(null).value

    LaunchedEffect(null) {
        viewModel.obtainEvent(UserListEvent.LoadUsers)
    }

    when (viewAction) {
        is UserListAction.ShowError -> {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(viewAction.message)
            }
        }

        is UserListAction.PerformNavigationToDetails -> {

        }

        else -> {}
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = KMPMarketTheme.colors.primaryBackground,
        snackbarHost = { SnackbarHost(snackbarHostState) }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CupertinoText(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                text = UsersResStrings.users,
                fontSize = 24.sp,
                color = KMPMarketTheme.colors.text,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(viewState.users.size) { position ->
                    UserCard(userCard = viewState.users[position])
                }
            }
        }
    }
}