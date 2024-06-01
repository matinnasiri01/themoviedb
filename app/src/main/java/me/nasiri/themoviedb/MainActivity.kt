package me.nasiri.themoviedb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import me.nasiri.core.data.repository.MovieRepositoryImpl
import me.nasiri.themoviedb.ui.theme.ThemoviedbTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // test
    @Inject
    lateinit var repo: MovieRepositoryImpl


    @SuppressLint("CoroutineCreationDuringComposition", "StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            var mainActivityVM = MainActivityVM(repo)
            val uiState by mainActivityVM.uiState.collectAsState()
            mainActivityVM.init()
            ThemoviedbTheme {
                screen(uiState)
            }
        }
    }

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun screen(uiState: UiState<Int, String>) {

        when (uiState) {
            is UiState.Error -> view(0)
            is UiState.Loading -> view(0)
            is UiState.Success -> view(uiState.value ?: 0)
        }
    }

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun view(size: Int) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) { ->
                Text(
                    text = "UI LIST SIZE : ${
                        if (size == 0) {
                            "PENDING..."
                        } else size.toString()
                    }",
                    modifier = Modifier
                        .padding(20.dp)
                        .padding(18.dp)
                )
            }
        }
    }
