package me.nasiri.data.mapper

import me.nasiri.database.Genre
import me.nasiri.database.entitys.MovieEntity
import me.nasiri.network.dto.MoviesListDto


fun MoviesListDto.convert(
    checkFavorite: (Int) -> Boolean?,
    checkGenre: (List<Int>) -> List<Genre>?,
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