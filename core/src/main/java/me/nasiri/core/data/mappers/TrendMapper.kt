package me.nasiri.core.data.mappers

import me.nasiri.core.data.model.TrendCore
import me.nasiri.core_network.model.TrendDto

fun TrendDto.format(): List<TrendCore> {
    return this.results?.map {
        TrendCore(
            id = it?.id,
            adult = it?.adult ?: false,
            backdropPath = it?.backdropPath,
            posterPath = it?.posterPath,
            originalTitle = it?.originalTitle,
            overview = it?.overview,
            releaseDate = it?.releaseDate,
            title = it?.title,
            genreIds = it?.genreIds,
        )
    }!!
}