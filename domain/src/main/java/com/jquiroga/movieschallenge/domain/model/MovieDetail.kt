package com.jquiroga.movieschallenge.domain.model

data class MovieDetail(
    val movie: Movie,
    val genres: List<Genre>,
    val runtimeMinutes: Int?,
    val tagline: String?,
    val status: String?
)