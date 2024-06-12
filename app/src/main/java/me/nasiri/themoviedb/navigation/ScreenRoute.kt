package me.nasiri.themoviedb.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenRoute(
    val route: String,
    val icon: ImageVector? = null,
    val title: String? = null,
) {
    data object HomeScreen : ScreenRoute("home", Icons.Default.Home, "Home")
    data object SearchScreen : ScreenRoute("search", Icons.Default.Search, "Search")
    data object FavouritesScreen : ScreenRoute("favourites", Icons.Default.Favorite, "Favourites")
    data object Details : ScreenRoute("details/{id}", icon = Icons.Default.ArrowDropDown, "Details")
}