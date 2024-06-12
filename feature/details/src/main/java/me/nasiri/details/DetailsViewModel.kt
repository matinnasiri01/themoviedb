package me.nasiri.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import me.nasiri.data.util.Constants.POST_ID
import me.nasiri.domain.model.Movie
import me.nasiri.domain.usecase.GetMovieByIdUseCase
import me.nasiri.domain.usecase.LikeItemUseCase
import me.nasiri.domain.util.State
import me.nasiri.domain.util.runOnIO
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getMovie: GetMovieByIdUseCase,
    private val likeMovie: LikeItemUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var state by mutableStateOf(State<Movie>())
        private set

    init {
        savedStateHandle.get<Int>(POST_ID)?.let { init(it) }
    }

    private fun init(id: Int) {
        state = state.copy(isLoading = true, error = null, data = null)
        runOnIO {
            delay(100)
            state = state.copy(isLoading = false, error = null, data = getMovie(id))
        }
    }

    fun like(id: Int) {
        runOnIO { likeMovie(id) }
    }
}