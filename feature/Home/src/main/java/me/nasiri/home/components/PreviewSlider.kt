package me.nasiri.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.Flow
import me.nasiri.core.data.model.MovieModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreviewSlider(list: Flow<List<MovieModel>>, modifier: Modifier = Modifier) {
    val data = list.collectAsState(initial = emptyList()).value
    val state = rememberPagerState(initialPage = 1) { data.size }

    /*LaunchedEffect(state) {
        while (true) {
            yield()
            delay(3000)
            val nextPage = (state.currentPage + 1) % data.size
            state.animateScrollToPage(nextPage)
        }
    }*/

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
    ) {
        Text(text = "Welcome!", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPager(state = state, contentPadding = PaddingValues(horizontal = 45.dp)) { page ->
            SliderItem(item = data[page % data.size], modifier = Modifier.graphicsLayer {
                val pageOffset = state.getOffsetFractionForPage(page).coerceIn(-1f, 1f)
                alpha = lerp(
                    start = 0.5f, stop = 1f, fraction = 1f - kotlin.math.abs(pageOffset)
                )
            })
        }
    }
}

@Composable
fun SliderItem(item: MovieModel, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(440.dp)
            .height(200.dp)
            .padding(horizontal = 8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp)),
            model = item.backdropPath,
            contentScale = ContentScale.Crop,
            contentDescription = "Image"
        )
        Text(
            text = item.title!!,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
        Text(
            text = item.releaseDate?.take(4)!!,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        )
    }
}
