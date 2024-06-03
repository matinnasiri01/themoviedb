package me.nasiri.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(state: HomeState, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        state.error?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }
    }
}