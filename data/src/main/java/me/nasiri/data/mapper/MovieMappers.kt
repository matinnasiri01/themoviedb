package me.nasiri.data.mapper

import me.nasiri.data.util.Constants.IMAGE_URI
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity
import me.nasiri.domain.model.Movie
import me.nasiri.network.dto.MoviesListDto


suspend fun MoviesListDto.convert(
    favourites: suspend (Int) -> Boolean?,
    genres: suspend (List<Int>) -> List<GenreEntity>?,
): List<MovieEntity> {
    return results?.mapNotNull {
        if (it == null) return@mapNotNull null
        MovieEntity(
            id = it.id,
            adult = it.adult ?: false,
            title = it.title,
            overview = it.overview,
            releaseDate = it.releaseDate,
            posterPath = IMAGE_URI + it.posterPath,
            backdropPath = IMAGE_URI + it.backdropPath,
            genres = genres(it.genreIds?.filterNotNull()!!) ?: emptyList(),
            isFavorite = favourites(it.id!!) ?: false,
        )
    }!!
}

fun MovieEntity.convert(): Movie {
    return Movie(
        id = id ?: 0,
        adult = adult,
        isFavorite = isFavorite,
        title = title ?: "",
        overview = overview ?: "",
        releaseDate = releaseDate ?: "",
        posterPath = posterPath ?: "",
        backdropPath = backdropPath ?: "",
        genres = genres.convert()
    )
}


fun List<MovieEntity>.convert(): List<Movie> = map { it.convert() }