package me.nasiri.domain.usecase

import kotlinx.coroutines.flow.Flow
import me.nasiri.domain.entities.Movie
import me.nasiri.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFavoriteDataUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<Movie>> = repository.getFavorites()
}