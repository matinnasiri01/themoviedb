package me.nasiri.core.data.mappers

import me.nasiri.core.data.model.FavouriteModel
import me.nasiri.core_database.entity.FavouriteEntity

fun FavouriteModel.format(): FavouriteEntity = FavouriteEntity(mvTitle, mvID)

fun FavouriteEntity.format(): FavouriteModel = FavouriteModel(mvTitle, mvID)