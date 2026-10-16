package com.jquiroga.movieschallenge.domain.repository

import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.result.DomainResult
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    suspend fun getFavorites(): DomainResult<List<Movie>>

    fun observeFavoriteIds(): Flow<Set<Long>>

    suspend fun addFavorite(movie: Movie): DomainResult<Unit>

    suspend fun removeFavorite(id: Long): DomainResult<Unit>

}