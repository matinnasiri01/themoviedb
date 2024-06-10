package me.nasiri.themoviedb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import me.nasiri.data.datasources.MovieDataSources
import me.nasiri.themoviedb.presentation.ui.theme.ThemoviedbTheme
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var remote: MovieDataSources.Remote

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ThemoviedbTheme {
                Scaffold { innerPadding ->
                    Text(
                        text = "Hello",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}