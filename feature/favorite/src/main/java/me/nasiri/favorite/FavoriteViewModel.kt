package me.nasiri.favorite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core.domain.usecase.GetFavoriteDataUseCase
import me.nasiri.core.until.Resource
import me.nasiri.core.until.StateModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getUseCase: GetFavoriteDataUseCase,
    private val repo: MovieRepository,
) : ViewModel() {
    var state by mutableStateOf(StateModel<Flow<List<MovieModel>>>())
        private set


    init {
        getData()
    }

    private fun getData() {
        getUseCase().onEach { result ->
            state = when (result) {
                is Resource.Success -> state.copy(data = result.data, isLoading = false)

                is Resource.Error -> state.copy(error = result.message, isLoading = false)

                is Resource.Loading -> state.copy(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    fun likeItem(id: Int) {
        viewModelScope.launch {
            val movie = repo.getMovieById(id)
            repo.updateFavourite(movie.copy(isFavorite = !movie.isFavorite))
        }
    }
}