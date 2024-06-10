package me.nasiri.domain.usecase

import me.nasiri.domain.repository.MovieRepository
import me.nasiri.domain.util.runOtherThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchMovieDataUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(page: Int = 1) = runOtherThread { repository.fetchMovies(page) }
}