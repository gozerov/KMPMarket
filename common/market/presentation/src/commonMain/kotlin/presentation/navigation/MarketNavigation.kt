package presentation.navigation

import domain.navigation.MarketNavigation
import navigation.Screen
import presentation.screens.details.ProductDetailsScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.marketFlow() {
    flow(MarketNavigation.FLOW) {
        screen(Screen.Market.ProductDetails.route) {
            ProductDetailsScreen(it as Int)
        }
    }
}