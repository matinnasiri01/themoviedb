package me.nasiri.core_network.model


import com.squareup.moshi.Json

data class MovieDetailDto(
    @Json(name = "adult")
    val adult: Boolean?,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: Any?,
    @Json(name = "budget")
    val budget: Int?,
    @Json(name = "genres")
    val genres: List<Genre?>?,
    @Json(name = "homepage")
    val homepage: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "images")
    val images: Images?,
    @Json(name = "imdb_id")
    val imdbId: Any?,
    @Json(name = "origin_country")
    val originCountry: List<String?>?,
    @Json(name = "original_language")
    val originalLanguage: String?,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "popularity")
    val popularity: Double?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompany?>?,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountry?>?,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "revenue")
    val revenue: Int?,
    @Json(name = "runtime")
    val runtime: Int?,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage?>?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "tagline")
    val tagline: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "video")
    val video: Boolean?,
    @Json(name = "vote_average")
    val voteAverage: Int?,
    @Json(name = "vote_count")
    val voteCount: Int?
) {
    data class Genre(
        @Json(name = "id")
        val id: Int?,
        @Json(name = "name")
        val name: String?
    )

    data class Images(
        @Json(name = "backdrops")
        val backdrops: List<Any?>?,
        @Json(name = "logos")
        val logos: List<Any?>?,
        @Json(name = "posters")
        val posters: List<Any?>?
    )

    data class ProductionCompany(
        @Json(name = "id")
        val id: Int?,
        @Json(name = "logo_path")
        val logoPath: Any?,
        @Json(name = "name")
        val name: String?,
        @Json(name = "origin_country")
        val originCountry: String?
    )

    data class ProductionCountry(
        @Json(name = "iso_3166_1")
        val iso31661: String?,
        @Json(name = "name")
        val name: String?
    )

    data class SpokenLanguage(
        @Json(name = "english_name")
        val englishName: String?,
        @Json(name = "iso_639_1")
        val iso6391: String?,
        @Json(name = "name")
        val name: String?
    )
}