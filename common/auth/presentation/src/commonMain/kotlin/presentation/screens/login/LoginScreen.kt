package presentation.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.navigation.MarketNavigation
import com.adeo.kviewmodel.odyssey.StoredViewModel
import navigation.Screen
import presentation.screens.login.models.LoginEvent
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.gozerov.kmpmarket.strings.ResStrings
import theme.KMPMarketTheme

@Composable
fun LoginScreen() {
    val controller = LocalRootController.current
    val parentController = LocalRootController.current.parentRootController

    StoredViewModel({ LoginViewModel() }) { viewModel ->

        val viewState = viewModel.viewStates().collectAsState().value

        Scaffold(
            backgroundColor = KMPMarketTheme.colors.primaryBackground
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = ResStrings.login,
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
                        parentController?.launch(Screen.Tabs.route)
                    }
                ) {
                    Text(text = ResStrings.sign_in, color = KMPMarketTheme.colors.text)
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        controller.push(Screen.Login.Register.route)
                    },
                    text = ResStrings.sign_up,
                    color = KMPMarketTheme.colors.accent,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}