package me.nasiri.core.data.mappers

import kotlinx.coroutines.runBlocking
import me.nasiri.core.data.model.GenreModel
import me.nasiri.core.data.model.MovieModel
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


fun MovieEntity.format(convert: suspend (List<Int>) -> List<GenreModel>): MovieModel {
    return MovieModel(
        id = id,
        adult = adult,
        title = title,
        isFavorite = isFavorite,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        originalLanguage = originalLanguage,
        genres = runBlocking { convert(genres) },
    )
}