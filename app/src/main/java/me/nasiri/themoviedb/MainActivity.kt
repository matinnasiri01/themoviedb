package me.nasiri.themoviedb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.themoviedb.ui.theme.ThemoviedbTheme
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repo: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThemoviedbTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(18.dp)
                    ) {
                        Button(onClick = {
                            runBlocking {
                                Toast.makeText(
                                    this@MainActivity,
                                    "${repo.getMovieGenre(listOf(878, 12, 28))}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }) {
                            Text(text = "GET")
                        }
                    }
                }
            }
        }
    }
}