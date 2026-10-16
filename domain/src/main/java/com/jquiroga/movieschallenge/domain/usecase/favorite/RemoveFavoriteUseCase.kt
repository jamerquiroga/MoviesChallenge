package com.jquiroga.movieschallenge.domain.usecase.favorite

import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import com.jquiroga.movieschallenge.domain.result.DomainResult

class RemoveFavoriteUseCase(
    private val repository: FavoriteRepository,
) {
    suspend operator fun invoke(id: Long): DomainResult<Unit> =
        repository.removeFavorite(id)
}