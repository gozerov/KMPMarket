package presentation.screens.list.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import domain.models.Product
import io.github.alexzhirkevich.cupertino.CupertinoButton
import io.github.alexzhirkevich.cupertino.CupertinoText
import io.github.alexzhirkevich.cupertino.ExperimentalCupertinoApi
import theme.KMPMarketTheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalCupertinoApi::class)
@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.padding(horizontal = 4.dp).size(280.dp),
        backgroundColor = KMPMarketTheme.colors.secondary,
        shape = RoundedCornerShape(16.dp),
        onClick = onClick
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
             CupertinoText(
                 modifier = Modifier.padding(horizontal = 12.dp),
                 text = product.title,
                 fontWeight = FontWeight.SemiBold,
                 maxLines = 2,
                 color = KMPMarketTheme.colors.text
             )
             CupertinoText(
                 modifier = Modifier.padding(all = 12.dp),
                 text = product.price.toString(),
                 fontWeight = FontWeight.Bold,
                 color = KMPMarketTheme.colors.accent
             )
             Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.BottomCenter) {
                 CupertinoButton(modifier = Modifier.padding(bottom = 16.dp).width(120.dp).height(40.dp), onClick = {}) {
                     CupertinoText("Click me")
                 }
             }
        }
    }
}