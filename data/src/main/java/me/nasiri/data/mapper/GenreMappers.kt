package me.nasiri.data.mapper

import me.nasiri.database.entitys.GenreEntity
import me.nasiri.network.dto.GenreDto

fun GenreDto.convert(): List<GenreEntity> =
    genres?.filterNotNull()?.map { GenreEntity(it.id, it.name) }!!