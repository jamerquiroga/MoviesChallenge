package com.jquiroga.movieschallenge.domain.usecase.favorite

import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class ObserveFavoriteStatusUseCase(
    private val repository: FavoriteRepository,
) {
    operator fun invoke(id: Long): Flow<Boolean> =
        repository.observeFavoriteIds()
            .map { favoriteIds -> id in favoriteIds }
            .distinctUntilChanged()
}