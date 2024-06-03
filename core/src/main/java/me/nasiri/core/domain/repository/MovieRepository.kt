package me.nasiri.core.domain.repository

import me.nasiri.core.data.model.FavouriteModel
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel
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
    suspend fun getMovieGenre(list: List<Int>): List<GenreModel>

    suspend fun getGenre(): List<GenreModel>

    suspend fun getMovie(): List<MovieModel>


    // Favourite
    suspend fun addFavourite(item: FavouriteModel)
    suspend fun removeFavourite(item: FavouriteModel)
    suspend fun getFavourite(): List<FavouriteModel>

}