package com.jquiroga.movieschallenge.data.datasource.local.source

import com.jquiroga.movieschallenge.data.datasource.local.entity.FavoriteMovieEntity


interface FavoriteLocalDataSource {

    suspend fun getFavorites(): List<FavoriteMovieEntity>

}