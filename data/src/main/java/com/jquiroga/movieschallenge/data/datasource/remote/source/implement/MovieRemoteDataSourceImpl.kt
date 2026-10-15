package com.jquiroga.movieschallenge.data.datasource.remote.source.implement

import com.jquiroga.movieschallenge.data.core.utils.ApiConfig
import com.jquiroga.movieschallenge.data.datasource.remote.api.MovieApi
import com.jquiroga.movieschallenge.data.datasource.remote.dto.MoviePageDto
import com.jquiroga.movieschallenge.data.datasource.remote.source.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val api: MovieApi,
) : MovieRemoteDataSource {

    override suspend fun getMovies(page: Int, query: String): MoviePageDto =
        if (query.isBlank()) {
            api.getPopularMovies(
                language = ApiConfig.DEFAULT_LANGUAGE,
                page = page,
            )
        } else {
            api.searchMovies(
                query = query,
                language = ApiConfig.DEFAULT_LANGUAGE,
                page = page,
            )
        }
}