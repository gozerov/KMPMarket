package navigation

sealed class Screen(
    val route: String
) {

    data object Tabs : Screen("tabs")

    sealed class Login(featureRoute: String) : Screen(featureRoute) {

        data object Login : Screen.Login("login")

        data object Register : Screen.Login("register")

    }

    sealed class Market(featureRoute: String) : Screen(featureRoute) {

        data object GoodsList : Market("goodsList")

    }

    sealed class Users(featureRoute: String) : Screen(featureRoute) {

        data object UserList: Users("userList")

    }

}