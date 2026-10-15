package com.jquiroga.movieschallenge.data.repository

import com.jquiroga.movieschallenge.data.datasource.local.mapper.toDomain
import com.jquiroga.movieschallenge.data.datasource.local.source.FavoriteLocalDataSource
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import com.jquiroga.movieschallenge.domain.result.DomainError
import com.jquiroga.movieschallenge.domain.result.DomainResult
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class FavoriteDataRepository @Inject constructor(
    private val localDataSource: FavoriteLocalDataSource
) : FavoriteRepository {

    override suspend fun getFavorites(): DomainResult<List<Movie>> =
        try {
            DomainResult.Success(
                localDataSource.getFavorites().map { favorite -> favorite.toDomain() },
            )
        } catch (error: CancellationException) {
            throw error
        } catch (error: Throwable) {
            DomainResult.Failure(DomainError.Unexpected(error))
        }

}