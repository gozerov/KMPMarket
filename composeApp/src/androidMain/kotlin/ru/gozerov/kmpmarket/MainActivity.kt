package ru.gozerov.kmpmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.alexzhirkevich.cupertino.theme.CupertinoTheme
import navigation.KMPMarketApp
import theme.KMPMarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KMPMarketTheme {
                CupertinoTheme {
                    KMPMarketApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}