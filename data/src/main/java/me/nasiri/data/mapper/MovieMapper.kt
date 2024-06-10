package me.nasiri.data.mapper

import me.nasiri.database.entity.MovieEntity
import me.nasiri.domain.entities.Genre
import me.nasiri.domain.entities.Movie
import me.nasiri.network.dto.MoviesListDto

fun MoviesListDto.convert(
    findFav: (Int) -> Boolean?,
    findGenres: (List<Int>) -> List<Genre>?,
): List<MovieEntity> {
    return results!!.mapNotNull {
        it ?: return@mapNotNull null
        MovieEntity(
            id = it.id!!,
            adult = it.adult!!,
            isFavorite = findFav(it.id!!) ?: false,
            title = it.title!!,
            overview = it.overview!!,
            releaseDate = it.releaseDate!!,
            posterPath = it.posterPath!!,
            backdropPath = it.backdropPath!!,
            genres = findGenres(it.genreIds?.filterNotNull()!!) ?: emptyList()
        )
    }

}

fun MovieEntity.convert(): Movie {
    return Movie(
        id = id,
        adult = adult,
        isFavorite = isFavorite,
        title = title,
        overview = overview,
        releaseDate = releaseDate,
        posterPath = posterPath,
        backdropPath = backdropPath,
        genres = genres,
    )
}

fun List<MovieEntity>.convert(): List<Movie> = map { it.convert() }