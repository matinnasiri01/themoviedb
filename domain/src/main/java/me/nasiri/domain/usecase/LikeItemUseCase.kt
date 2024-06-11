package me.nasiri.domain.usecase

import me.nasiri.domain.repository.MovieRepository
import me.nasiri.domain.util.runOnIO
import javax.inject.Inject

class LikeItemUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(itemId: Int) = runOnIO { repository.updateFaivouriteMovies(itemId) }
}