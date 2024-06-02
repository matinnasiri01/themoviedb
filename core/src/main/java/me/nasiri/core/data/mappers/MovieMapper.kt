package me.nasiri.core.data.mappers


import me.nasiri.core.data.model.GenreCore
import me.nasiri.core.data.model.MovieCore
import me.nasiri.core_network.model.MovieDetailDto

fun MovieDetailDto.format(): MovieCore {
    return MovieCore(
        id = id,
        imdbID = imdbId.toString(),
        title = originalTitle,
        adult = adult,
        status = status,
        genres = genres?.map { GenreCore(id = it?.id, name = it?.name) },
        backdropPath = backdropPath,
        posterPath = posterPath,
        originalLanguage = originalLanguage,
        originCountry = originCountry
    )
}