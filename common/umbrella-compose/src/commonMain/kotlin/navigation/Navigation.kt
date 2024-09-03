package navigation

import presentation.navigation.authFlow
import presentation.navigation.marketFlow
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
fun RootComposeBuilder.navigationGraph() {
    authFlow()
    marketFlow()
}