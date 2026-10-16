package com.jquiroga.movieschallenge.domain.usecase.home

import androidx.paging.PagingData
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(private val repository: MovieRepository) {

    operator fun invoke(query: String): Flow<PagingData<Movie>> = repository.getMovies(query.trim())

}