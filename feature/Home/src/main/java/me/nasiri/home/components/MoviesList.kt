//package me.nasiri.home.components
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.SubcomposeAsyncImage
//import me.nasiri.core.data.model.MovieModel
//
//@Composable
//fun MoviesList(list: List<MovieModel>, modifier: Modifier = Modifier) {
//    LazyColumn(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(horizontal = 6.dp)
//    ) {
//
//        item {
//            Text(text = "Movies", fontSize = 30.sp, fontWeight = FontWeight.Bold)
//        }
//        itemsIndexed(list) { index, item ->
//            MovieItem(item = item)
//        }
//    }
//}
//
//@Composable
//fun MovieItem(item: MovieModel, modifier: Modifier = Modifier) {
//    Row(
//        modifier = modifier
//            .fillMaxWidth()
//            .height(160.dp)
//            .padding(horizontal = 8.dp, vertical = 10.dp)
//            .clickable { }
//    ) {
//        SubcomposeAsyncImage(
//            modifier = Modifier
//                .fillMaxHeight()
//                .clip(RoundedCornerShape(15.dp)),
//            model = item.posterPath,
//            contentScale = ContentScale.FillHeight,
//            loading = {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) { CircularProgressIndicator() }
//            },
//            contentDescription = null,
//        )
//        Spacer(modifier = Modifier.width(10.dp))
//        Column {
//            Text(
//                text = "${item.title} (${item.releaseDate?.dropLast(6)})",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold
//            )
//            Text(text = item.genres.map { it.name }.toString().replace("[", "").replace("]", ""))
//        }
//    }
//}