package com.jquiroga.movieschallenge.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jquiroga.movieschallenge.data.datasource.local.dao.FavoriteMovieDao
import com.jquiroga.movieschallenge.data.datasource.local.entity.FavoriteMovieEntity

@Database(
    entities = [FavoriteMovieEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class MoviePagingDatabase : RoomDatabase() {
    abstract fun favoriteMovieDao(): FavoriteMovieDao
}
