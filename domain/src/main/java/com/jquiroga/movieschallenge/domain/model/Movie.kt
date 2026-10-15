package com.jquiroga.movieschallenge.domain.model

data class Movie(
    val id: Long,
    val title: String,
    val overview: String,
    val posterUrl: String?,
    val backdropUrl: String?,
    val releaseDate: String?,
    val voteAverage: Double,
    val voteCount: Int
)