package presentation.screens.list.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import domain.models.Product
import theme.KMPMarketTheme

@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.padding(horizontal = 4.dp).size(180.dp),
        backgroundColor = KMPMarketTheme.colors.secondary,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = product.title,
                fontWeight = FontWeight.SemiBold,
                color = KMPMarketTheme.colors.text
            )
            Text(
                modifier = Modifier.padding(all = 12.dp),
                text = product.price.toString(),
                fontWeight = FontWeight.Bold,
                color = KMPMarketTheme.colors.accent
            )
        }
    }
}