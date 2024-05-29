package me.nasiri.core_network

import me.nasiri.core_network.util.Constants.GET_MOVIEID
import me.nasiri.core_network.model.MoviesIDDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {


    @GET(GET_MOVIEID)
    suspend fun getAllMoviesId(
        // @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
    ): MoviesIDDto
}