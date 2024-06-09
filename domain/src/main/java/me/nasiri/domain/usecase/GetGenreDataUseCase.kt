package me.nasiri.domain.usecase

import kotlinx.coroutines.flow.Flow
import me.nasiri.domain.entities.Genre
import me.nasiri.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetGenreDataUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<Genre>> = repository.getGenres()
}