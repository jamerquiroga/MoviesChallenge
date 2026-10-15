package com.jquiroga.movieschallenge.domain.usecase

import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.repository.FavoriteRepository
import com.jquiroga.movieschallenge.domain.result.DomainResult

class GetFavoriteMoviesUseCase(
    private val repository: FavoriteRepository,
) {
    suspend operator fun invoke(): DomainResult<List<Movie>> = repository.getFavorites()
}
