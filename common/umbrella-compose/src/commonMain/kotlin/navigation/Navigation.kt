package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import navigation.bottom_bar.MainScreen
import presentation.navigation.authFlow
import presentation.screens.details.ProductDetailsScreen

@Composable
fun KMPMarketApp() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: Screen.Tabs.route

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Tabs.route
        ) {
            authFlow(navController = navController)

            composable(route = Screen.Tabs.route) {
                MainScreen()
            }

            composable(route = "${Screen.Market.ProductDetails.route}/{id}") { entry ->
                ProductDetailsScreen(
                    id = entry.arguments?.getString("id")?.toInt() ?: 0,
                    navController = navController
                )
            }
        }
    }
}