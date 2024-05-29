package me.nasiri.core_network

import me.nasiri.core_network.model.GenreDto
import me.nasiri.core_network.model.MovieDetailDto
import me.nasiri.core_network.util.Constants.GET_MOVIEID
import me.nasiri.core_network.model.MoviesIDDto
import me.nasiri.core_network.model.TrendDto
import me.nasiri.core_network.util.Constants.GET_GENRE
import me.nasiri.core_network.util.Constants.GET_MOVIES_DETAIL
import me.nasiri.core_network.util.Constants.GET_TREND_MOVIES
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET(GET_GENRE)
    suspend fun getAllGenreList(): GenreDto

    @GET(GET_MOVIEID)
    suspend fun getAllMoviesId(
        @Query("page") page: Int = 1,
    ): MoviesIDDto


    @GET(GET_MOVIES_DETAIL)
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("append_to_response") app: String = "videos,images",
    ): MovieDetailDto


    @GET(GET_TREND_MOVIES)
    suspend fun getTrendMovies(
        @Path("time_window") period: String = "day",
    ): TrendDto
}