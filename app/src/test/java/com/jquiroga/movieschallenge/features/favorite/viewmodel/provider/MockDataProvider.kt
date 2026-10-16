package com.jquiroga.movieschallenge.features.favorite.viewmodel.provider

import com.jquiroga.movieschallenge.domain.model.Movie

object MockDataProvider {
    fun createMovie(
        id: Long = 1L,
        title: String = "The Movie",
        posterUrl: String? = "https://image.tmdb.org/poster.jpg",
        releaseDate: String? = "2026-10-15",
        voteAverage: Double = 8.5
    ) = Movie(
        id = id,
        title = title,
        overview = "Movie overview",
        posterUrl = posterUrl,
        backdropUrl = "https://image.tmdb.org/backdrop.jpg",
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = 100
    )
}
