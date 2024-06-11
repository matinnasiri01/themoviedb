package me.nasiri.domain.repository

import kotlinx.coroutines.flow.Flow
import me.nasiri.domain.model.Genre
import me.nasiri.domain.model.Movie

interface MovieRepository {

    fun getMovies(): Flow<List<Movie>>
    suspend fun getMovie(id: Int): Movie?
    fun getGenres(): List<Genre>
    fun getFavouriteMovies(): Flow<List<Movie>>

    suspend fun fetchMovies(page: Int = 1)
    suspend fun fetchGenres()
    suspend fun updateFaivouriteMovies(movie: Movie)

}