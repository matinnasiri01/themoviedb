package me.nasiri.core.data.mappers

import me.nasiri.core.data.model.GenreCore
import me.nasiri.core_network.model.GenreDto

fun GenreDto.format(): List<GenreCore> =
    this.genres?.map { GenreCore(id = it?.id, name = it?.name) }!!
