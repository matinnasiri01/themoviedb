package me.nasiri.domain.usecase

import kotlinx.coroutines.flow.Flow
import me.nasiri.domain.model.Movie
import me.nasiri.domain.repository.MovieRepository
import javax.inject.Inject


class GetFavoriteDataUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<Movie>> = repository.getFavouriteMovies()
}