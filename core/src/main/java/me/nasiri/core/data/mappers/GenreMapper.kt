package me.nasiri.core.data.mappers

import me.nasiri.core_database.entity.GenreModel
import me.nasiri.core_network.model.GenreDto

fun GenreDto.format(): List<GenreModel> =
    this.genres?.map { GenreModel(id = it?.id, name = it?.name) }!!
