package com.jquiroga.movieschallenge.di

import com.jquiroga.movieschallenge.domain.repository.MovieRepository
import com.jquiroga.movieschallenge.domain.usecase.GetMovieDetailUseCase
import com.jquiroga.movieschallenge.domain.usecase.GetMoviesUseCase
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
}
