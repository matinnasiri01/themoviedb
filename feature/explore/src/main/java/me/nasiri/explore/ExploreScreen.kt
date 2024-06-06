package me.nasiri.explore

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.nasiri.core_ui.error.ErrorMessage
import me.nasiri.core_ui.item.MovieItem
import me.nasiri.core_ui.search.CuSearch

@Composable
fun ExploreScreen(viewmodel: ExploreViewModel = hiltViewModel()) {
    val state = viewmodel.state
    var search by rememberSaveable { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {

        state.data?.let {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                    CuSearch(value = search, onValueChange = { search = it })
                    Spacer(modifier = Modifier.height(16.dp))
                }
                items(it) { i -> MovieItem(data = i) }
            }
        }
        state.error?.let { ErrorMessage(message = it, modifier = Modifier.align(Alignment.Center)) }
        if (state.isLoading) CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}