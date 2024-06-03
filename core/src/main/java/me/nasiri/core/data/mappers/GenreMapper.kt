package me.nasiri.core.data.mappers

import me.nasiri.core.data.model.GenreModel
import me.nasiri.core_database.entity.GenreEntity
import me.nasiri.core_network.model.GenreDto

fun GenreDto.format(): List<GenreEntity> =
    this.genres?.map { GenreEntity(id = it?.id, name = it?.name) }!!


fun List<GenreEntity>.format(): List<GenreModel> =
    this.map { GenreModel(id = it.id, name = it.name) }