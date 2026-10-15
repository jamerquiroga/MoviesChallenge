package com.jquiroga.movieschallenge.data.datasource.remote.source

import com.jquiroga.movieschallenge.data.datasource.remote.dto.MovieDetailDto
import com.jquiroga.movieschallenge.data.datasource.remote.dto.MoviePageDto

interface MovieRemoteDataSource {

    suspend fun getMovies(page: Int, query: String): MoviePageDto

    suspend fun getMovieDetail(movieId: Long): MovieDetailDto

}