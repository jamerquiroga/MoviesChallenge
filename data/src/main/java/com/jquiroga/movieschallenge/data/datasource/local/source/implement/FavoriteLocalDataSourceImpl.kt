package com.jquiroga.movieschallenge.data.datasource.local.source.implement

import com.jquiroga.movieschallenge.data.datasource.local.dao.FavoriteMovieDao
import com.jquiroga.movieschallenge.data.datasource.local.entity.FavoriteMovieEntity
import com.jquiroga.movieschallenge.data.datasource.local.source.FavoriteLocalDataSource
import javax.inject.Inject

class FavoriteLocalDataSourceImpl @Inject constructor(
    private val favoriteMovieDao: FavoriteMovieDao
): FavoriteLocalDataSource {

    override suspend fun getFavorites(): List<FavoriteMovieEntity> {
        return favoriteMovieDao.getFavorites()
    }
}