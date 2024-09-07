package navigation

import navigation.bottom_bar.BottomConfiguration
import navigation.bottom_bar.BottomTab
import presentation.navigation.authFlow
import presentation.navigation.marketFlow
import presentation.screens.list.ProductListScreen
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
fun RootComposeBuilder.navigationGraph() {
    authFlow()
    bottomNavigation(Screen.Tabs.route, BottomConfiguration()) {
        tab(tabItem = BottomTab.MarketTab) {
            screen(Screen.Market.ProductList.route) {
                ProductListScreen()
            }
        }
        tab(tabItem = BottomTab.UsersTab) {
            screen(Screen.Users.UserList.route) {
              //  UserListScreen()
            }
        }
    }
    marketFlow()
}