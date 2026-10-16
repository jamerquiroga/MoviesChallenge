package com.jquiroga.movieschallenge.data.datasource.local.source

import com.jquiroga.movieschallenge.data.datasource.local.entity.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow


interface FavoriteLocalDataSource {

    suspend fun getFavorites(): List<FavoriteMovieEntity>

    fun observeFavoriteIds(): Flow<Set<Long>>

    suspend fun addFavorite(favorite: FavoriteMovieEntity)

    suspend fun removeFavorite(movieId: Long)

}