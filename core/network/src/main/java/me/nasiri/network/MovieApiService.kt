package me.nasiri.network

import me.nasiri.core_network.model.MoviesListDto
import me.nasiri.network.dto.GenreDto
import me.nasiri.network.util.Constants.GET_GENRE
import me.nasiri.network.util.Constants.GET_MOVIES
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET(GET_GENRE)
    suspend fun getAllGenreList(): GenreDto

    @GET(GET_MOVIES)
    suspend fun getAllMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): MoviesListDto

}