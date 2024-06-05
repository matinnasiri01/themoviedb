package me.nasiri.themoviedb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core.until.StateModel
import me.nasiri.favorite.FavoriteScreen
import me.nasiri.themoviedb.presentation.ui.theme.ThemoviedbTheme
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val data = runBlocking {
            repository.getFavourite()
        }
        setContent {
            ThemoviedbTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        FavoriteScreen(state = StateModel(data = data))
                    }
                }
            }
        }
    }
}