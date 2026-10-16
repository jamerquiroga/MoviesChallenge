package com.jquiroga.movieschallenge.domain.usecase.detail.provider

import com.jquiroga.movieschallenge.domain.model.Genre
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.model.MovieDetail

object MockDataProvider {

    fun createMovieDetail() = MovieDetail(
        movie = Movie(
            id = 1L,
            title = "The Movie",
            overview = "Movie overview",
            posterUrl = "https://example.com/poster.jpg",
            backdropUrl = "https://example.com/backdrop.jpg",
            releaseDate = "2026-10-15",
            voteAverage = 8.5,
            voteCount = 100
        ),
        genres = listOf(
            Genre(id = 28, name = "Action")
        ),
        runtimeMinutes = 120,
        tagline = "Movie tagline",
        status = "Released"
    )
}