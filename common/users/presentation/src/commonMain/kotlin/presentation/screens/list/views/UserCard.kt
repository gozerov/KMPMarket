package presentation.screens.list.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import domain.models.UserCard
import io.github.alexzhirkevich.cupertino.CupertinoText
import theme.KMPMarketTheme

@Composable
internal fun UserCard(userCard: UserCard) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = KMPMarketTheme.colors.secondary)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = userCard.image,
                contentDescription = null,
                modifier = Modifier
                    .padding(all = 8.dp)
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            CupertinoText(
                text = "${userCard.firstName} ${userCard.lastName}",
                maxLines = 1,
                color = KMPMarketTheme.colors.text
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}