package presentation.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import domain.navigation.MarketNavigation
import kotlinx.coroutines.launch
import presentation.screens.list.models.ProductListAction
import presentation.screens.list.models.ProductListEvent
import presentation.screens.list.views.ProductCard
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.gozerov.kmpmarket.market.presentation.strings.MarketResStrings
import theme.KMPMarketTheme

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = viewModel { ProductListViewModel() }
) {

    val parentController = LocalRootController.current.parentRootController?.parentRootController
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    val viewState = viewModel.viewStates().collectAsState().value
    val viewAction = viewModel.viewActions().collectAsState(null).value

    LaunchedEffect(null) {
        viewModel.obtainEvent(ProductListEvent.LoadProducts)
    }

    when (viewAction) {
        is ProductListAction.ShowError -> {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(viewAction.message)
            }
        }

        is ProductListAction.PerformNavigationToDetails -> {}
        else -> {}
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = KMPMarketTheme.colors.primaryBackground,
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                text = MarketResStrings.products,
                fontSize = 24.sp,
                color = KMPMarketTheme.colors.text,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(32.dp))
            LazyVerticalGrid(
                GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                items(viewState.products.size) { ind ->
                    ProductCard(viewState.products[ind]) {
                        parentController?.push(
                            MarketNavigation.FLOW,
                            viewState.products[ind].id
                        )
                    }
                }
            }
        }
    }
}