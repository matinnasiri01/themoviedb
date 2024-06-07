package me.nasiri.explore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.domain.usecase.GetExploreDataUseCase
import me.nasiri.core.until.Resource
import me.nasiri.core.until.StateModel
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val getUseCase: GetExploreDataUseCase,
) : ViewModel() {
    var state by mutableStateOf(StateModel<List<MovieModel>>())
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
}