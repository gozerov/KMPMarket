package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun KMPMarketTheme(
    textSize: KMPMarketSize = KMPMarketSize.Medium,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) baseDarkPalette else baseLightPalette

    val typography = KMPMarketTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                KMPMarketSize.Small -> 20.sp
                KMPMarketSize.Medium -> 24.sp
                KMPMarketSize.Big -> 28.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                KMPMarketSize.Small -> 14.sp
                KMPMarketSize.Medium -> 16.sp
                KMPMarketSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                KMPMarketSize.Small -> 14.sp
                KMPMarketSize.Medium -> 16.sp
                KMPMarketSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                KMPMarketSize.Small -> 10.sp
                KMPMarketSize.Medium -> 12.sp
                KMPMarketSize.Big -> 14.sp
            }
        )
    )

    CompositionLocalProvider(
        LocalKMPMarketColors provides colors,
        LocalKMPMarketTypography provides typography,
        content = content
    )
}