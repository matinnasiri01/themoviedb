package me.nasiri.search

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.nasiri.search.component.CuSearch
import me.nasiri.search.component.MovieItem

@Composable
fun SearchScreen(vm: SearchViewModel = hiltViewModel(), modifier: Modifier = Modifier) {
    val state = vm.state
    var text by remember { mutableStateOf("") }
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading) item { CircularProgressIndicator() }
        state.error?.let { item { Text(text = it) } }
        state.data?.let {
            item {
                CuSearch(value = text, onValueChange = { newText -> text = newText })
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(it) { movie ->
                MovieItem(data = movie, onClick = { /*todo*/ }) { item -> vm.like(item) }
            }
        }
    }
}