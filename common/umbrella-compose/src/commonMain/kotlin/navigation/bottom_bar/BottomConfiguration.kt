package navigation.bottom_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabsNavModel
import theme.KMPMarketTheme

class BottomConfiguration : TabsNavModel<BottomNavConfiguration>() {

    override val navConfiguration: BottomNavConfiguration
        @Composable
        get() {
            return BottomNavConfiguration(
                elevation = 0.dp,
                backgroundColor = KMPMarketTheme.colors.primaryBackground,
                selectedColor = KMPMarketTheme.colors.accent,
                unselectedColor = KMPMarketTheme.colors.text
            )
        }

}