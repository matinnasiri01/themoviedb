package me.nasiri.core.data.mappers

import me.nasiri.core_database.entity.Genre
import me.nasiri.core_database.entity.MovieModel
import me.nasiri.core_database.entity.SpokenLanguage
import me.nasiri.core_network.model.MovieDetailDto

fun MovieDetailDto.format(): MovieModel {
    return MovieModel(
        id = this.id,
        imdbID = this.imdbId.toString(),
        title = this.title,
        tagline = this.tagline,
        adult = this.adult ?: false,
        status = this.status,
        des = this.overview,
        genres = this.genres?.map { Genre(id = it?.id, name = it?.name) },
        releaseDate = this.releaseDate,
        backdropPath = this.backdropPath.toString(),
        posterPath = this.posterPath,
        originalLanguage = this.originalLanguage,
        originCountry = this.originCountry ?: emptyList(),
        spokenLanguages = this.spokenLanguages?.map {
            SpokenLanguage(
                englishName = it?.englishName,
                iso = it?.iso6391,
                name = it?.name
            )
        } ?: emptyList(),

        )
}