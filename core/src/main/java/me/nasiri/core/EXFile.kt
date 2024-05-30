package me.nasiri.core

import me.nasiri.core.data.model.GenreModel
import me.nasiri.core_network.model.GenreDto

/*
*       for test
*/



fun GenreDto.format(): List<GenreModel>? =
    this.genres?.map { GenreModel(id = it?.id, name = it?.name) }
