package me.nasiri.favourite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import me.nasiri.domain.model.Movie
import me.nasiri.domain.usecase.GetFavoriteDataUseCase
import me.nasiri.domain.usecase.LikeItemUseCase
import me.nasiri.domain.util.State
import me.nasiri.domain.util.runOnIO
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val getMovies: GetFavoriteDataUseCase,
    private val likeMovie: LikeItemUseCase,
) : ViewModel() {

    var state by mutableStateOf(State<List<Movie>>())
        private set

    init {
        init()
    }

    private fun init() {
        state = state.copy(isLoading = true, error = null, data = null)
        runOnIO {
            delay(100)
            getMovies().collect {
                state = state.copy(isLoading = false, error = null, data = it)
            }
        }
    }

    fun like(id: Int) {
        runOnIO { likeMovie(id) }
    }
}