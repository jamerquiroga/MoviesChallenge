package com.jquiroga.movieschallenge.feature.detail.movie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.detail.data.MovieDetailPreviewData
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailUiState
import com.jquiroga.movieschallenge.features.detail.ui.movie.MovieDetailScreen

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun MovieDetailScreenPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MovieDetailScreen(
            uiState = MovieDetailUiState.Content(
                movie = MovieDetailPreviewData.movie,
                isFavorite = true
            ),
            onBackClick = {},
            onRetryClick = {},
            onFavoriteClick = {}
        )
    }
}