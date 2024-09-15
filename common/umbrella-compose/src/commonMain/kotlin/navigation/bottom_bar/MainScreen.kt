package navigation.bottom_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import domain.navigation.MarketNavigation
import domain.navigation.UsersNavigation
import navigation.Screen
import presentation.screens.list.ProductListScreen
import presentation.screens.list.UserListScreen
import theme.KMPMarketTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(MarketNavigation.FLOW, UsersNavigation.FLOW)

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController,
            modifier = Modifier.padding(bottom = 56.dp).fillMaxSize(),
            startDestination = MarketNavigation.FLOW
        ) {
            navigation(startDestination = Screen.Market.ProductList.route, route = MarketNavigation.FLOW) {
                composable(Screen.Market.ProductList.route) { ProductListScreen() }
            }
            navigation(startDestination = Screen.Users.UserList.route, route = UsersNavigation.FLOW) {
                composable(Screen.Users.UserList.route) { UserListScreen() }
            }
        }

        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomStart),
            backgroundColor = KMPMarketTheme.colors.primaryBackground
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { },
                    label = { Text(screen, color = KMPMarketTheme.colors.text) },
                    selected = currentDestination?.hierarchy?.any { it.route == screen } == true,
                    onClick = {
                        navController.navigate(screen) {
                            // Pop up to  the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().route.toString()) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }

    }
}