package me.nasiri.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import me.nasiri.domain.model.Genre
import me.nasiri.domain.model.Movie
import me.nasiri.domain.usecase.FetchGenreDataUseCase
import me.nasiri.domain.usecase.FetchMovieDataUseCase
import me.nasiri.domain.usecase.GetGenreDataUseCase
import me.nasiri.domain.usecase.GetMovieDataUseCase
import me.nasiri.domain.usecase.LikeItemUseCase
import me.nasiri.domain.util.State
import me.nasiri.domain.util.runOnIO
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchMovies: FetchMovieDataUseCase,
    private val fetchGenres: FetchGenreDataUseCase,
    private val getMovies: GetMovieDataUseCase,
    private val getGenres: GetGenreDataUseCase,
    private val likeMovie: LikeItemUseCase,
) : ViewModel() {

    var state by mutableStateOf(State<Pair<List<Movie>, List<Genre>>>())
        private set

    init {
        init()
    }

    private fun init() {
        state = state.copy(isLoading = true, error = null, data = null)
        runOnIO {
            delay(100)
            getMovies().collect {
                state = if (it.isNotEmpty()) {
                    state.copy(isLoading = false, error = null, data = Pair(it, getGenres()))
                } else {
                    state.copy(isLoading = false, error = "Check your Connection", data = null)
                }
            }
        }
    }

    fun refreshData() {
        state = state.copy(isLoading = true, error = null, data = null)
        runOnIO {
            fetchMovies()
            fetchGenres()
        }
        init()
    }

    fun like(id: Int) {
        runOnIO { likeMovie(id) }
    }
}