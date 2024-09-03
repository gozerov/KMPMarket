package presentation.navigation

import domain.navigation.AuthNavigation
import navigation.Screen
import presentation.screens.login.LoginScreen
import presentation.screens.register.RegisterScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.authFlow() {
    flow(AuthNavigation.FLOW) {
        screen(Screen.Login.Login.route) {
            LoginScreen()
        }
        screen(Screen.Login.Register.route) {
            RegisterScreen()
        }
    }
}