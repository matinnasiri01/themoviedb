package me.nasiri.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.nasiri.core.domain.usecase.GetGenreUseCase
import me.nasiri.core.domain.usecase.GetMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getGenreUseCase: GetGenreUseCase,
) : ViewModel()