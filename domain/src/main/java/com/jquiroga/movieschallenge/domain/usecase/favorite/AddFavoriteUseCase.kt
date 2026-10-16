package com.jquiroga.movieschallenge.domain.usecase.favorite

import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import com.jquiroga.movieschallenge.domain.result.DomainResult

class AddFavoriteUseCase(
    private val repository: FavoriteRepository,
) {
    suspend operator fun invoke(movie: Movie): DomainResult<Unit> =
        repository.addFavorite(movie = movie)
}