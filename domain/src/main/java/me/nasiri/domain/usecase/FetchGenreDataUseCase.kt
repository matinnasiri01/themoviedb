package me.nasiri.domain.usecase

import me.nasiri.domain.repository.MovieRepository
import me.nasiri.domain.util.runOnIO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchGenreDataUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke() = runOnIO { repository.fetchGenres() }
}