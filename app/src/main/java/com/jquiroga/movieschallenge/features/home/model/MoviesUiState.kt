package com.jquiroga.movieschallenge.features.home.model

data class MoviesUiState(
    val catalog: MovieCatalog = MovieCatalog.Popular,
)

enum class MovieCatalog {
    Popular
}
