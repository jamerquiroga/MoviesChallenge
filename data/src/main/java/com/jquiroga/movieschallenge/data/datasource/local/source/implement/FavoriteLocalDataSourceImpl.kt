package com.jquiroga.movieschallenge.data.datasource.local.source.implement

import com.jquiroga.movieschallenge.data.datasource.local.dao.FavoriteMovieDao
import com.jquiroga.movieschallenge.data.datasource.local.entity.FavoriteMovieEntity
import com.jquiroga.movieschallenge.data.datasource.local.source.FavoriteLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteLocalDataSourceImpl @Inject constructor(
    private val favoriteMovieDao: FavoriteMovieDao
) : FavoriteLocalDataSource {

    override suspend fun getFavorites(): List<FavoriteMovieEntity> {
        return favoriteMovieDao.getFavorites()
    }

    override fun observeFavoriteIds(): Flow<Set<Long>> =
        favoriteMovieDao.observeFavoriteIds().map { ids -> ids.toSet() }

    override suspend fun addFavorite(favorite: FavoriteMovieEntity) {
        favoriteMovieDao.addFavorite(favorite)
    }

    override suspend fun removeFavorite(movieId: Long) {
        favoriteMovieDao.removeFavorite(movieId)
    }
}