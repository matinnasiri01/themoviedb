package me.nasiri.core_network

import me.nasiri.core_network.util.Constants.GET_IMDB_DETAIL
import me.nasiri.core_network.util.Constants.HAJI_API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbApiService {

    @GET(GET_IMDB_DETAIL)
    suspend fun getImdbDataById(
        @Query("q") type: String = "film",
        @Query("id") id: String,
        @Query("license") license: String = HAJI_API_KEY,
    ) /*todo*/
}