package me.nasiri.core_network.model


import com.squareup.moshi.Json

data class MoviesIDDto(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: List<Result?>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?,
) {
    data class Result(
        @Json(name = "adult")
        val adult: Boolean?,
        @Json(name = "id")
        val id: Int?,
    )
}