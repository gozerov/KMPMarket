package ru.gozerov.kmpmarket

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import io.github.alexzhirkevich.cupertino.theme.CupertinoTheme
import navigation.KMPMarketApp
import theme.KMPMarketTheme

fun MainViewController() = ComposeUIViewController {
    SafeArea {
        KMPMarketTheme {
            CupertinoTheme {
                KMPMarketApp()
            }
        }
    }
}

@Composable
internal fun SafeArea(
    content: @Composable () -> Unit
) {
    Column(modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing).fillMaxSize()) {
        content.invoke()
    }
}