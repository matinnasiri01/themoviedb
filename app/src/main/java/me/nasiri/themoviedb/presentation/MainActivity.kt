package me.nasiri.themoviedb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.nasiri.themoviedb.navigation.AppNavHost
import me.nasiri.themoviedb.navigation.MainNavigation
import me.nasiri.themoviedb.presentation.ui.theme.ThemoviedbTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { ThemoviedbTheme { MyApp() } }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { MainNavigation(navController) }) { innerPadding ->
        AppNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}