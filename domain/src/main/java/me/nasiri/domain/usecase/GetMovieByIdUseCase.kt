package me.nasiri.domain.usecase

import kotlinx.coroutines.runBlocking
import me.nasiri.domain.model.Movie
import me.nasiri.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(movieId: Int): Movie {
        return runBlocking { repository.getMovie(movieId) ?: throw Exception("Movie not found") }
    }
}