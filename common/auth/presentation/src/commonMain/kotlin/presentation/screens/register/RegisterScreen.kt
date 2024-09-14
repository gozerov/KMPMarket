package presentation.screens.register

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import navigation.Screen
import presentation.screens.register.models.RegisterAction
import presentation.screens.register.models.RegisterEvent
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.gozerov.kmpmarket.auth.presentation.strings.AuthResStrings
import theme.KMPMarketTheme

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel { RegisterViewModel() }
) {
    val controller = LocalRootController.current
    val parentController = LocalRootController.current.parentRootController

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val viewState = viewModel.viewStates().collectAsState().value
    val viewAction = viewModel.viewActions().collectAsState(RegisterAction.None).value

    when (viewAction) {
        is RegisterAction.PerformNavigationToTabs -> {
            parentController?.launch(Screen.Tabs.route)
        }

        is RegisterAction.ShowError -> {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(viewAction.message)
            }
        }

        else -> {}
    }

    Scaffold(
        backgroundColor = KMPMarketTheme.colors.primaryBackground,
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = AuthResStrings.registration,
                color = KMPMarketTheme.colors.text,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            )
            Spacer(Modifier.height(24.dp))
            TextField(
                modifier = Modifier.padding(horizontal = 48.dp).fillMaxWidth(),
                value = viewState.email,
                onValueChange = { value ->
                    viewModel.obtainEvent(RegisterEvent.UpdateEmail(value))
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = KMPMarketTheme.colors.text,
                    backgroundColor = KMPMarketTheme.colors.secondary,
                    focusedIndicatorColor = KMPMarketTheme.colors.accent,
                    unfocusedIndicatorColor = KMPMarketTheme.colors.secondaryBackground,
                    cursorColor = KMPMarketTheme.colors.accent
                )
            )
            Spacer(Modifier.height(24.dp))
            TextField(
                modifier = Modifier.padding(horizontal = 48.dp).fillMaxWidth(),
                value = viewState.password,
                onValueChange = { value ->
                    viewModel.obtainEvent(RegisterEvent.UpdatePassword(value))
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = KMPMarketTheme.colors.text,
                    backgroundColor = KMPMarketTheme.colors.secondary,
                    focusedIndicatorColor = KMPMarketTheme.colors.accent,
                    unfocusedIndicatorColor = KMPMarketTheme.colors.secondaryBackground,
                    cursorColor = KMPMarketTheme.colors.accent
                )
            )
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                modifier = Modifier.padding(horizontal = 48.dp).fillMaxWidth().height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = KMPMarketTheme.colors.accent,
                    contentColor = KMPMarketTheme.colors.text
                ),
                onClick = {
                    viewModel.obtainEvent(RegisterEvent.NavigateToTabs)
                }
            ) {
                Text(text = AuthResStrings.sign_up, color = KMPMarketTheme.colors.text)
            }
        }
    }
}