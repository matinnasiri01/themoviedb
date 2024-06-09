package me.nasiri.domain.usecase

import me.nasiri.domain.entities.Movie
import me.nasiri.domain.repository.MovieRepository
import me.nasiri.domain.until.runOtherThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LikeItemUseCase @Inject constructor(private val repository: MovieRepository) {
    fun like(item: Movie) = runOtherThread { repository.updateFavourite(item) }
}