package com.jquiroga.movieschallenge.features.detail.model

sealed interface MovieDetailUiState {
    data object Loading : MovieDetailUiState

    data class Content(
        val movie: MovieDetailUiModel,
        val isFavorite: Boolean,
        val isFavoriteUpdating: Boolean = false,
        val favoriteUpdateFailed: Boolean = false
    ) : MovieDetailUiState

    data class Error(
        val type: MovieDetailError,
    ) : MovieDetailUiState
}

enum class MovieDetailError {
    NetworkUnavailable,
    NotFound,
    Generic
}