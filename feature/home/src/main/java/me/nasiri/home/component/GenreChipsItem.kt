package me.nasiri.home.component

import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import me.nasiri.domain.model.Genre

@Composable
fun GenreChipsItem(genre: Genre, list: MutableList<Int>) {
    val id = genre.id
    FilterChip(selected = id in list, onClick = {
        if (id in list) list.remove(id) else list.add(id)
    }, label = { Text(text = genre.name) })
}