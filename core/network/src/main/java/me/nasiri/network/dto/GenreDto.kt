package me.nasiri.network.dto


import com.squareup.moshi.Json

data class GenreDto(
    @field:Json(name = "genres")
    val genres: List<Genre?>?,
) {
    data class Genre(
        @field:Json(name = "id")
        val id: Int?,
        @field:Json(name = "name")
        val name: String?,
    )
}