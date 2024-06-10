package me.nasiri.domain.repository

import kotlinx.coroutines.flow.Flow
import me.nasiri.domain.entities.Genre
import me.nasiri.domain.entities.Movie

interface MovieRepository {

    suspend fun fetchMovies(page: Int = 1)
    suspend fun fetchGenres()

    fun getMovies(): Flow<List<Movie>>
    fun getMovieById(movieId: Int): Movie
    fun getGenres(): List<Genre>
    fun getFavorites(): Flow<List<Movie>>

    suspend fun updateFavourite(movieId: Int)

}