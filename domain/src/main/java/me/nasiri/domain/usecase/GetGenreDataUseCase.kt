package me.nasiri.domain.usecase

import me.nasiri.domain.model.Genre
import me.nasiri.domain.repository.MovieRepository
import javax.inject.Inject


class GetGenreDataUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): List<Genre> = repository.getGenres()
}