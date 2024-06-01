package me.nasiri.core.domain.repository

import kotlinx.coroutines.flow.Flow
import me.nasiri.core_database.entity.GenreModel
import me.nasiri.core_database.entity.MovieModel
import me.nasiri.core_database.entity.TrendModel

interface MovieRepository {

    suspend fun getGenre(): Flow<List<GenreModel>>

    suspend fun getTrendMovies(/*todo set the type*/): Flow<List<TrendModel>>

    suspend fun getMovieList(): Flow<List<MovieModel>>

    suspend fun getMovieDetailsById(mvID: Int): Flow<MovieModel>


    suspend fun fetchGenre()

    suspend fun fetchTrendMovies()

    suspend fun fetchMovies()


}