package presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import domain.navigation.AuthNavigation
import navigation.Screen
import presentation.screens.login.LoginScreen
import presentation.screens.register.RegisterScreen

fun NavGraphBuilder.authFlow(navController: NavController) {
    navigation(startDestination = Screen.Login.Login.route, route = AuthNavigation.FLOW) {
        composable(route = Screen.Login.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Login.Register.route) {
            RegisterScreen(navController = navController)
        }
    }
}