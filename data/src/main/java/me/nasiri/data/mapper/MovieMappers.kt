package me.nasiri.data.mapper

import me.nasiri.data.model.Movie
import me.nasiri.database.entitys.GenreEntity
import me.nasiri.database.entitys.MovieEntity
import me.nasiri.network.dto.MoviesListDto


fun MoviesListDto.convert(
    checkFavorite: (Int) -> Boolean?,
    checkGenre: (List<Int>) -> List<GenreEntity>?,
): List<MovieEntity> {
    return results?.mapNotNull {
        it ?: return@mapNotNull null
        MovieEntity(
            id = it.id,
            adult = it.adult ?: false,
            isFavorite = checkFavorite(it.id!!) ?: false,
            title = it.title,
            overview = it.overview,
            releaseDate = it.releaseDate,
            posterPath = it.posterPath,
            backdropPath = it.backdropPath,
            genres = checkGenre(it.genreIds?.filterNotNull()!!) ?: emptyList()
        )
    }!!
}

fun MovieEntity.convert(): Movie {
    return Movie(
        id = id!!,
        adult = adult,
        isFavorite = isFavorite,
        title = title!!,
        overview = overview!!,
        releaseDate = releaseDate!!,
        posterPath = posterPath!!,
        backdropPath = backdropPath!!,
        genres = genres.convert()
    )
}


fun List<MovieEntity>.convert(): List<Movie> = map { it.convert() }