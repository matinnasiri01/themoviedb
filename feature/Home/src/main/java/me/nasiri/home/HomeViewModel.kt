package me.nasiri.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.domain.repository.MovieRepository
import me.nasiri.core.domain.usecase.GetHomeDataUseCase
import me.nasiri.core.until.Resource
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase,
    private val repository: MovieRepository,
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set


    fun test(): List<MovieModel> {
        return runBlocking {
            repository.fRefresh()
            repository.getMovie()
        }
    }

    fun getHomeData() {
        getHomeDataUseCase().onEach { result ->
            state = when (result) {
                is Resource.Success -> state.copy(data = result.data, isLoading = false)

                is Resource.Error -> state.copy(error = result.message, isLoading = false)

                is Resource.Loading -> state.copy(isLoading = true)
            }
        }
    }
}