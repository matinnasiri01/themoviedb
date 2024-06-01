package me.nasiri.themoviedb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.nasiri.core.data.repository.MovieRepositoryImpl


class MainActivityVM(var repo: MovieRepositoryImpl) :
    ViewModel() {


    private val _uiState = MutableStateFlow<UiState<Int, String>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun init() {

        viewModelScope.launch(context = Dispatchers.IO) {

            _uiState.value = UiState.Error("Get API")
            var s = repo.getMovieList()
            _uiState.value = UiState.Success(s?.size?:0)

        }
    }

}