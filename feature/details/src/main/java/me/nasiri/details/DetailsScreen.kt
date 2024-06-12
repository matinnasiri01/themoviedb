package me.nasiri.details

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.nasiri.details.component.Header

@Composable
fun DetailsScreen(modifier: Modifier = Modifier, vm: DetailsViewModel = hiltViewModel()) {
    val movie = vm.state
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (movie.isLoading) item { CircularProgressIndicator() }
        movie.error?.let { error -> item { Text(text = error) } }
        movie.data?.let { mv ->
            item { Header(mv) }
            item {
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = "Plot Summary", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = mv.overview,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Genres", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = mv.genres.map { it.name }.toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", "  "),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        }
    }
}