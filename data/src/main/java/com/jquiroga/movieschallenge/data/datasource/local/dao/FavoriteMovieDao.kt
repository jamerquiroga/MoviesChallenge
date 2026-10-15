package com.jquiroga.movieschallenge.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jquiroga.movieschallenge.data.datasource.local.entity.FavoriteMovieEntity

@Dao
interface FavoriteMovieDao {

    @Query("SELECT * FROM favorite_movies ORDER BY saved_at_epoch_millis DESC")
    suspend fun getFavorites(): List<FavoriteMovieEntity>

}