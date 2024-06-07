package me.nasiri.core.domain.repository

import kotlinx.coroutines.flow.Flow
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel

interface MovieRepository {

    // Refresh
    suspend fun fRefresh() {
        fMovies()
        fGenre()
    }


    suspend fun fMovies()
    suspend fun fGenre()
    suspend fun getMovieGenre(list: List<Int>): List<GenreModel>

    suspend fun getMovieById(id: Int): MovieModel

    suspend fun getGenre(): List<GenreModel>

    suspend fun getMovie(): List<MovieModel>


    // Favourite
    suspend fun updateFavourite(item: MovieModel)
    suspend fun getFavourite(): Flow<List<MovieModel>>

}