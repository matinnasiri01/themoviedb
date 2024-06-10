package me.nasiri.data.mapper

import me.nasiri.database.entity.GenreEntity
import me.nasiri.domain.entities.Genre
import me.nasiri.network.dto.GenreDto

fun GenreDto.convert(): List<GenreEntity> {
    return genres?.mapNotNull {
        it ?: return@mapNotNull null
        GenreEntity(id = it.id!!, it.name!!)
    }!!
}

fun GenreEntity.convert(): Genre = Genre(id = id, name = name)

fun List<GenreEntity>.convert(): List<Genre> = map { it.convert() }