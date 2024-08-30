package navigation

import presentation.navigation.authFlow
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.navigationGraph() {
    authFlow()
}