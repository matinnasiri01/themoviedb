package me.nasiri.home.component


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import coil.compose.SubcomposeAsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import me.nasiri.domain.model.Movie

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun Carousel(list: List<Movie>, modifier: Modifier = Modifier) {

    val state = rememberPagerState(initialPage = 1) { list.size }

    LaunchedEffect(state) {
        while (true) {
            yield()
            delay(3000)
            val nextPage = (state.currentPage + 1) % list.size
            state.animateScrollToPage(nextPage)
        }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(state = state, contentPadding = PaddingValues(horizontal = 45.dp)) { page ->
            SliderItem(
                item = list[page % list.size],
                modifier = Modifier.graphicsLayer {
                    val pageOffset = state.getOffsetFractionForPage(page).coerceIn(-1f, 1f)
                    alpha = lerp(
                        start = 0.4f,
                        stop = 1f,
                        fraction = 1f - kotlin.math.abs(pageOffset)
                    )
                }
            )
        }
    }
}

@Composable
fun SliderItem(item: Movie, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(440.dp)
            .height(200.dp)
            .padding(horizontal = 8.dp)
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp)),
            model = item.backdropPath,
            loading = { CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)) },
            contentScale = ContentScale.Crop,
            contentDescription = "Image"
        )
        Text(
            text = item.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold, color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
        Text(
            text = item.releaseDate.take(4),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold, color = Color.White,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        )
    }
}