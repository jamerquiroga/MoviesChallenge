package com.jquiroga.movieschallenge.di

import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import com.jquiroga.movieschallenge.domain.repository.MovieRepository
import com.jquiroga.movieschallenge.domain.usecase.favorite.GetFavoriteMoviesUseCase
import com.jquiroga.movieschallenge.domain.usecase.detail.GetMovieDetailUseCase
import com.jquiroga.movieschallenge.domain.usecase.home.GetMoviesUseCase
import com.jquiroga.movieschallenge.domain.usecase.favorite.AddFavoriteUseCase
import com.jquiroga.movieschallenge.domain.usecase.favorite.ObserveFavoriteStatusUseCase
import com.jquiroga.movieschallenge.domain.usecase.favorite.RemoveFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetMovies(repository: MovieRepository): GetMoviesUseCase = GetMoviesUseCase(repository)

    @Provides
    @Singleton
    fun provideGetMovieDetail(repository: MovieRepository): GetMovieDetailUseCase =
        GetMovieDetailUseCase(repository)

    @Provides
    @Singleton
    fun provideGetFavoriteMovies(repository: FavoriteRepository): GetFavoriteMoviesUseCase =
        GetFavoriteMoviesUseCase(repository)

    @Provides
    @Singleton
    fun provideObserveFavoriteStatus(repository: FavoriteRepository): ObserveFavoriteStatusUseCase =
        ObserveFavoriteStatusUseCase(repository)

    @Provides
    @Singleton
    fun provideAddFavorite(repository: FavoriteRepository): AddFavoriteUseCase =
        AddFavoriteUseCase(repository)

    @Provides
    @Singleton
    fun provideRemoveFavorite(repository: FavoriteRepository): RemoveFavoriteUseCase =
        RemoveFavoriteUseCase(repository)
}
