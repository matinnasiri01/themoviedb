package me.nasiri.core.domain.repository

import me.nasiri.core_database.entity.FavouriteEntity
import me.nasiri.core_database.entity.GenreEntity
import me.nasiri.core_database.entity.MovieEntity

interface MovieRepository {

    // Refresh
    suspend fun fRefresh() {
        fMovies()
        fGenre()
    }


    suspend fun fMovies()
    suspend fun fGenre()
    suspend fun getMovieGenre(list: List<Int>): List<String>

    suspend fun getGenre(): List<GenreEntity>

    suspend fun getMovie(): List<MovieEntity>


    // Favourite
    suspend fun addFavourite(item: FavouriteEntity)
    suspend fun removeFavourite(item: FavouriteEntity)
    suspend fun getFavourite(): List<FavouriteEntity>

}