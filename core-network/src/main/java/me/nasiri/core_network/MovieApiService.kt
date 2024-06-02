package me.nasiri.core_network

import me.nasiri.core_network.model.GenreDto
import me.nasiri.core_network.model.MovieDetailDto
import me.nasiri.core_network.util.Constants.GET_MOVIES
import me.nasiri.core_network.model.MoviesListDto
import me.nasiri.core_network.util.Constants.GET_GENRE
import me.nasiri.core_network.util.Constants.GET_MOVIE_DETAIL
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET(GET_GENRE)
    suspend fun getAllGenreList(): GenreDto

    @GET(GET_MOVIES)
    suspend fun getAllMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): MoviesListDto

    @GET(GET_MOVIE_DETAIL)
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("append_to_response") app: String = "videos,images",
    ): MovieDetailDto

}