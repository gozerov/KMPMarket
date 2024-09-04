package navigation.bottom_bar

import androidx.compose.runtime.Composable
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem

sealed interface BottomTab {

    data object MarketTab : TabItem(), BottomTab {
        override val configuration: TabConfiguration
            @Composable
            get() {
                return TabConfiguration(
                    title = "Market",
                )
            }
    }

    data object UsersTab : TabItem(), BottomTab {
        override val configuration: TabConfiguration
            @Composable
            get() {
                return TabConfiguration(
                    title = "Users",
                )
            }
    }

}