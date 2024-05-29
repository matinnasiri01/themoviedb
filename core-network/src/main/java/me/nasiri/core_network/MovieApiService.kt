package me.nasiri.core_network

import me.nasiri.core_network.model.GenreDto
import me.nasiri.core_network.util.Constants.GET_MOVIEID
import me.nasiri.core_network.model.MoviesIDDto
import me.nasiri.core_network.util.Constants.GET_GENRE
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {


    @GET(GET_MOVIEID)
    suspend fun getAllMoviesId(
        @Query("page") page: Int = 1,
    ): MoviesIDDto

    @GET(GET_GENRE)
    suspend fun getAllGenreList(): GenreDto
}