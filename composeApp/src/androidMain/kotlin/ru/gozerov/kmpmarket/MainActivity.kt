package ru.gozerov.kmpmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import di.Injector
import domain.repository.LoginRepository
import kotlinx.coroutines.launch
import navigation.navigationGraph
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.alexgladkov.odyssey.core.configuration.DisplayType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val configuration = OdysseyConfiguration(
                canvas = this,
                displayType = DisplayType.EdgeToEdge,
                backgroundColor = Color.White
            )

            setNavigationContent(configuration) {
                navigationGraph()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}