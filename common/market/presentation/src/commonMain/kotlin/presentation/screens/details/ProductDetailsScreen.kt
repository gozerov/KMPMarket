package presentation.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.adeo.kviewmodel.odyssey.StoredViewModel
import kotlinx.coroutines.launch
import presentation.screens.details.models.ProductDetailsAction
import presentation.screens.details.models.ProductDetailsEvent
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.KMPMarketTheme

@Composable
fun ProductDetailsScreen(id: Int) {

    val controller = LocalRootController.current
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    StoredViewModel({ ProductDetailsViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().collectAsState().value
        val viewAction = viewModel.viewActions().collectAsState(null).value

        when (viewAction) {
            is ProductDetailsAction.ShowError -> {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(viewAction.message)
                }
            }

            else -> {}
        }

        LaunchedEffect(null) {
            viewModel.obtainEvent(ProductDetailsEvent.LoadProduct(id))
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            backgroundColor = KMPMarketTheme.colors.primaryBackground
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(48.dp)
                        .padding(4.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = { controller.popBackStack() }
                        ),
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = KMPMarketTheme.colors.text
                )

                viewState.product?.let { product ->
                    Spacer(modifier = Modifier.height(24.dp))
                    AsyncImage(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .height(320.dp),
                        model = product.images.firstOrNull(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = product.title,
                        color = KMPMarketTheme.colors.text,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = product.description,
                        color = KMPMarketTheme.colors.text,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }

}