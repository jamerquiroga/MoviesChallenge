package com.jquiroga.movieschallenge.domain.usecase.detail

import com.jquiroga.movieschallenge.domain.model.MovieDetail
import com.jquiroga.movieschallenge.domain.repository.MovieRepository
import com.jquiroga.movieschallenge.domain.result.DomainResult

class GetMovieDetailUseCase(
    private val repository: MovieRepository,
) {
    suspend operator fun invoke(id: Long): DomainResult<MovieDetail> =
        repository.getMovieDetail(id)
}