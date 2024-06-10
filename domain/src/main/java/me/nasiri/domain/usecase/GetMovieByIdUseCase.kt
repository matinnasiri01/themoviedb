package me.nasiri.domain.usecase

import me.nasiri.domain.entities.Movie
import me.nasiri.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMovieByIdUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(movieId: Int): Movie = repository.getMovieById(movieId = movieId)
}