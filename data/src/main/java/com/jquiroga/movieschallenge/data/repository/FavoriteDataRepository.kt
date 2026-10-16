package com.jquiroga.movieschallenge.data.repository

import com.jquiroga.movieschallenge.data.core.utils.time.TimeProvider
import com.jquiroga.movieschallenge.data.datasource.local.mapper.toDomain
import com.jquiroga.movieschallenge.data.datasource.local.mapper.toEntity
import com.jquiroga.movieschallenge.data.datasource.local.source.FavoriteLocalDataSource
import com.jquiroga.movieschallenge.data.datasource.remote.mapper.toDomainError
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import com.jquiroga.movieschallenge.domain.result.DomainError
import com.jquiroga.movieschallenge.domain.result.DomainResult
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteDataRepository @Inject constructor(
    private val localDataSource: FavoriteLocalDataSource,
    private val timeProvider: TimeProvider
) : FavoriteRepository {

    override suspend fun getFavorites(): DomainResult<List<Movie>> =
        try {
            DomainResult.Success(
                localDataSource.getFavorites().map { favorite -> favorite.toDomain() },
            )
        } catch (error: CancellationException) {
            throw error
        } catch (error: Throwable) {
            DomainResult.Failure(error = DomainError.Unexpected(cause = error))
        }

    override fun observeFavoriteIds(): Flow<Set<Long>> =
        localDataSource.observeFavoriteIds().map { ids -> ids.toSet() }

    override suspend fun addFavorite(movie: Movie): DomainResult<Unit> =
        try {
            localDataSource.addFavorite(
                favorite = movie.toEntity(savedAtEpochMillis = timeProvider.currentTimeMillis())
            )
            DomainResult.Success(value = Unit)
        } catch (error: CancellationException) {
            throw error
        } catch (error: Throwable) {
            DomainResult.Failure(error.toDomainError())
        }

    override suspend fun removeFavorite(id: Long): DomainResult<Unit> =
        try {
            localDataSource.removeFavorite(movieId = id)
            DomainResult.Success(value = Unit)
        } catch (error: CancellationException) {
            throw error
        } catch (error: Throwable) {
            DomainResult.Failure(error.toDomainError())
        }
}