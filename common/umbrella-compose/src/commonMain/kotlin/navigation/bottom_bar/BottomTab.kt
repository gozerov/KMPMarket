package navigation.bottom_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem
import ru.gozerov.kmpmarket.common.`umbrella-compose`.resources.Res
import ru.gozerov.kmpmarket.common.`umbrella-compose`.resources.ic_market
import ru.gozerov.kmpmarket.common.`umbrella-compose`.resources.ic_users

sealed interface BottomTab {

    data object MarketTab : TabItem(), BottomTab {
        override val configuration: TabConfiguration
            @Composable
            get() {
                return TabConfiguration(
                    title = "Market",
                    selectedIcon = painterResource(Res.drawable.ic_market),
                    unselectedIcon = painterResource(Res.drawable.ic_market),
                    titleStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)
                )
            }
    }

    data object UsersTab : TabItem(), BottomTab {
        override val configuration: TabConfiguration
            @Composable
            get() {
                return TabConfiguration(
                    title = "Users",
                    selectedIcon = painterResource(Res.drawable.ic_users),
                    unselectedIcon = painterResource(Res.drawable.ic_users),
                    titleStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
                )
            }
    }

}