package me.nasiri.core.domain.repository

import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel
import me.nasiri.core.data.model.TrendModel
import me.nasiri.core_network.model.MoviesIDDto

interface MovieRepository {

    suspend fun getGenre(): List<GenreModel>

    suspend fun getTrendMovies(/*todo set the type*/): List<TrendModel>

    suspend fun getMovieList(): List<MoviesIDDto.Result?>?

    suspend fun getMovieDetailsById(mvID: Int): MovieModel


    suspend fun fetchGenre()

    suspend fun fetchTrendMovies()

    suspend fun fetchMovies()


}