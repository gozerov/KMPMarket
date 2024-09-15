package presentation.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import presentation.screens.details.models.ProductDetailsAction
import presentation.screens.details.models.ProductDetailsEvent
import theme.KMPMarketTheme

@Composable
fun ProductDetailsScreen(
    id: Int,
    navController: NavController,
    viewModel: ProductDetailsViewModel = viewModel { ProductDetailsViewModel() }
) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

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
                        onClick = { navController.popBackStack() }
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