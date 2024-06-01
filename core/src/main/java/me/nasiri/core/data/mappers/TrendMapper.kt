package me.nasiri.core.data.mappers

import me.nasiri.core_database.entity.TrendModel
import me.nasiri.core_network.model.TrendDto

fun TrendDto.format(): List<TrendModel> {
    return this.results?.map {
        TrendModel(
            id = it?.id,
            adult = it?.adult ?: false,
            backdropPath = it?.backdropPath,
            posterPath = it?.posterPath,
            originalTitle = it?.originalTitle,
            des = it?.overview,
            releaseDate = it?.releaseDate,
            title = it?.title,
            genreIds = it?.genreIds,
        )
    }!!
}