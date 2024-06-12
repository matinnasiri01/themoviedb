package me.nasiri.themoviedb.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.nasiri.data.util.Constants.POST_ID
import me.nasiri.details.DetailsScreen
import me.nasiri.favourite.FavouriteScreen
import me.nasiri.home.HomeScreen
import me.nasiri.search.SearchScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ScreenRoute.HomeScreen.route
    ) {
        composable(ScreenRoute.HomeScreen.route) { HomeScreen() }
        composable(ScreenRoute.SearchScreen.route) { SearchScreen() }
        composable(ScreenRoute.FavouritesScreen.route) { FavouriteScreen() }
        composable(
            ScreenRoute.Details.route,
            arguments = listOf(navArgument(POST_ID) { type = NavType.IntType })
        ) { DetailsScreen() }
    }
}