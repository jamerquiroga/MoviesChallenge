package com.jquiroga.movieschallenge.features.favorite.model

sealed interface FavoritesUiState {
    data object Loading : FavoritesUiState

    data object Empty : FavoritesUiState

    data class Content(
        val movies: List<FavoriteMovieUiModel>,
    ) : FavoritesUiState

    data object Error : FavoritesUiState
}