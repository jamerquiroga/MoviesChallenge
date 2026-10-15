package com.jquiroga.movieschallenge.domain.repository

import androidx.paging.PagingData
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.model.MovieDetail
import com.jquiroga.movieschallenge.domain.result.DomainResult
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(query: String): Flow<PagingData<Movie>>

    suspend fun getMovieDetail(id: Long): DomainResult<MovieDetail>

}