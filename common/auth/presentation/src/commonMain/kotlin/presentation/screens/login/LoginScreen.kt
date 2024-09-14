package presentation.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import presentation.screens.login.models.LoginAction
import presentation.screens.login.models.LoginEvent
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.gozerov.kmpmarket.auth.presentation.strings.AuthResStrings
import theme.KMPMarketTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel { LoginViewModel() }
) {
    val controller = LocalRootController.current
    val parentController = LocalRootController.current.parentRootController
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val viewState = viewModel.viewStates().collectAsState().value
    val viewAction = viewModel.viewActions().collectAsState(LoginAction.None).value

    when (viewAction) {
        is LoginAction.PerformNavigationToRegister -> {}
        is LoginAction.PerformNavigationToFeature -> {
            parentController?.launch(Screen.Tabs.route)
        }

        is LoginAction.ShowError -> {
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
                text = AuthResStrings.login,
                color = KMPMarketTheme.colors.text,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            )
            Spacer(Modifier.height(24.dp))
            TextField(
                modifier = Modifier.padding(horizontal = 48.dp).fillMaxWidth(),
                value = viewState.emailState,
                onValueChange = { value ->
                    viewModel.obtainEvent(LoginEvent.UpdateEmail(value))
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
                value = viewState.passwordState,
                onValueChange = { value ->
                    viewModel.obtainEvent(LoginEvent.UpdatePassword(value))
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
                    viewModel.obtainEvent(LoginEvent.NavigateToFeature)
                }
            ) {
                Text(text = AuthResStrings.sign_in, color = KMPMarketTheme.colors.text)
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    controller.push(Screen.Login.Register.route)
                },
                text = AuthResStrings.sign_up,
                color = KMPMarketTheme.colors.accent,
                fontWeight = FontWeight.Bold
            )
        }
    }
}