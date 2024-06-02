package me.nasiri.core.data.mappers

import me.nasiri.core.until.Constants.BASE_IMAGE
import me.nasiri.core_database.entity.MovieEntity
import me.nasiri.core_network.model.MoviesListDto

fun MoviesListDto.format(): List<MovieEntity> {
    return results?.mapNotNull {
        try {
            if (it == null) return@mapNotNull null
            MovieEntity(
                id = it.id,
                adult = it.adult ?: false,
                title = it.title,
                overview = it.overview,
                posterPath = BASE_IMAGE + it.posterPath,
                backdropPath = BASE_IMAGE + it.backdropPath,
                releaseDate = it.releaseDate,
                originalLanguage = it.originalLanguage,
                genres = it.genreIds?.filterNotNull() ?: emptyList()
            )
        } catch (e: Exception) {
            null
        }
    } ?: emptyList()
}
