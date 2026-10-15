package com.jquiroga.movieschallenge.domain.repository

import androidx.paging.PagingData
import com.jquiroga.movieschallenge.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(query: String): Flow<PagingData<Movie>>

}