package com.jquiroga.movieschallenge.domain.repository

import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.result.DomainResult

interface FavoriteRepository {

    suspend fun getFavorites(): DomainResult<List<Movie>>

}