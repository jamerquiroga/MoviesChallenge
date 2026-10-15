package com.jquiroga.movieschallenge.data.di

import android.content.Context
import androidx.room.Room
import com.jquiroga.movieschallenge.data.datasource.local.dao.FavoriteMovieDao
import com.jquiroga.movieschallenge.data.datasource.local.db.MoviePagingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    internal fun provideDatabase(
        @ApplicationContext context: Context,
    ): MoviePagingDatabase = Room.databaseBuilder(
        context = context,
        klass = MoviePagingDatabase::class.java,
        name = DATABASE_NAME,
    ).build()

    @Provides
    internal fun provideFavoriteMovieDao(database: MoviePagingDatabase): FavoriteMovieDao =
        database.favoriteMovieDao()

    private const val DATABASE_NAME = "movie-challenge.db"

}