package com.jquiroga.movieschallenge.feature.favorite.data

import com.jquiroga.movieschallenge.features.favorite.model.FavoriteMovieUiModel

internal object FavoritesPreviewData {
    val movie = FavoriteMovieUiModel(
        id = 603L,
        title = "Matrix",
        posterUrl = null,
        releaseYear = "1999",
        voteAverage = 8.2
    )

    val movies = listOf(
        movie,
        movie.copy(id = 27205L, title = "El origen", releaseYear = "2010", voteAverage = 8.4),
        movie.copy(id = 155L, title = "Batman: El caballero de la noche", releaseYear = "2008")
    )
}
