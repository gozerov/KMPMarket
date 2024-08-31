package theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

data class KMPMarketColors(
    val text: Color,
    val primary: Color,
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val secondary: Color,
    val accent: Color
)

data class KMPMarketTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

enum class KMPMarketSize {
    Small, Medium, Big
}

object KMPMarketTheme {
    val colors: KMPMarketColors
        @Composable
        get() = LocalKMPMarketColors.current

    val typography: KMPMarketTypography
        @Composable
        get() = LocalKMPMarketTypography.current

}

val LocalKMPMarketColors = staticCompositionLocalOf<KMPMarketColors> {
    error("No colors provided")
}

val LocalKMPMarketTypography = staticCompositionLocalOf<KMPMarketTypography> {
    error("No font provided")
}