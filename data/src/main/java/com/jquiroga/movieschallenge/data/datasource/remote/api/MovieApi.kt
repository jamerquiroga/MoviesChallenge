package com.jquiroga.movieschallenge.data.datasource.remote.api


import com.jquiroga.movieschallenge.data.datasource.remote.dto.MoviePageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): MoviePageDto

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MoviePageDto

}