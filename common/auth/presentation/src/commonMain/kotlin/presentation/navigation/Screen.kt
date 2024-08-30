package presentation.navigation

internal sealed class Screen(
    val route: String
) {

    data object Login : Screen("login")

    data object Register: Screen("register")

}