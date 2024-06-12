package me.nasiri.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.nasiri.domain.model.Movie
import me.nasiri.domain.usecase.FetchMovieDataUseCase
import me.nasiri.domain.usecase.GetMovieDataUseCase
import me.nasiri.domain.usecase.LikeItemUseCase
import me.nasiri.domain.util.State
import me.nasiri.domain.util.runOnIO
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val fetchMovies: FetchMovieDataUseCase,
    private val getMovies: GetMovieDataUseCase,
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
            getMovies().collect {
                state = if (it.isNotEmpty()) {
                    state.copy(isLoading = false, error = null, data = it)
                } else {
                    state.copy(isLoading = false, error = "Check your Connection", data = null)
                }
            }
        }
    }

    fun refreshData() {
        state = state.copy(isLoading = true, error = null, data = null)
        runOnIO { fetchMovies() }
        init()
    }

    fun like(id: Int) {
        runOnIO { likeMovie(id) }
    }
}