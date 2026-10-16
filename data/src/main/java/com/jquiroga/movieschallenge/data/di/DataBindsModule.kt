package com.jquiroga.movieschallenge.data.di

import com.jquiroga.movieschallenge.data.core.utils.time.SystemTimeProvider
import com.jquiroga.movieschallenge.data.core.utils.time.TimeProvider
import com.jquiroga.movieschallenge.data.datasource.local.source.FavoriteLocalDataSource
import com.jquiroga.movieschallenge.data.datasource.local.source.implement.FavoriteLocalDataSourceImpl
import com.jquiroga.movieschallenge.data.datasource.remote.source.MovieRemoteDataSource
import com.jquiroga.movieschallenge.data.datasource.remote.source.implement.MovieRemoteDataSourceImpl
import com.jquiroga.movieschallenge.data.repository.FavoriteDataRepository
import com.jquiroga.movieschallenge.data.repository.MovieDataRepository
import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import com.jquiroga.movieschallenge.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBindsModule {

    @Binds
    abstract fun bindMovieRemoteDataSource(
        impl: MovieRemoteDataSourceImpl
    ): MovieRemoteDataSource

    @Binds
    abstract fun bindMovieRepository(
        impl: MovieDataRepository
    ): MovieRepository

    @Binds
    abstract fun bindFavoriteLocalDataSource(
        impl: FavoriteLocalDataSourceImpl
    ): FavoriteLocalDataSource

    @Binds
    abstract fun bindFavoriteRepository(
        impl: FavoriteDataRepository
    ): FavoriteRepository

    @Binds
    abstract fun bindTimeProvider(
        impl: SystemTimeProvider
    ): TimeProvider

}