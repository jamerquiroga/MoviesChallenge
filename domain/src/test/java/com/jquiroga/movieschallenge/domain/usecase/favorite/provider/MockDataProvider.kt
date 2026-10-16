package com.jquiroga.movieschallenge.domain.usecase.favorite.provider

import com.jquiroga.movieschallenge.domain.model.Movie

object MockDataProvider {

    fun createMovie() = Movie(
        id = 1L,
        title = "The Movie",
        overview = "Movie overview",
        posterUrl = "https://example.com/poster.jpg",
        backdropUrl = "https://example.com/backdrop.jpg",
        releaseDate = "2026-10-15",
        voteAverage = 8.5,
        voteCount = 100
    )
}