package me.nasiri.search.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import me.nasiri.domain.model.Movie

@Composable
fun MovieItem(data: Movie, onClick: (Int) -> Unit, onLikeClick: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 8.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .clickable { onClick(data.id) }) {

            SubcomposeAsyncImage(
                modifier = Modifier
                    .size(110.dp)
                    .clip(RoundedCornerShape(16.dp)),
                model = data.posterPath,
                loading = { CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)) },
                contentDescription = "image"
            )
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = data.title.take(10),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "(${data.releaseDate.take(4)})", fontSize = 12.sp)
                }
                Text(
                    text = data.genres.map { it.name }.toString().replace("[", "")
                        .replace("]", "")
                )
            }
        }
        IconButton(
            onClick = { onLikeClick(data.id) },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Icon(
                imageVector = if (data.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                tint = if (data.isFavorite) Color.Red else Color.Gray,
                contentDescription = "Like"
            )
        }
    }
}