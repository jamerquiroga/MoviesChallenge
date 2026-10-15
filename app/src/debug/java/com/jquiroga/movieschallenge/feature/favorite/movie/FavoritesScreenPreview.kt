package com.jquiroga.movieschallenge.feature.favorite.movie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.feature.favorite.data.FavoritesPreviewData
import com.jquiroga.movieschallenge.features.favorite.model.FavoritesUiState
import com.jquiroga.movieschallenge.features.favorite.ui.movie.FavoritesScreen

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
private fun FavoritesScreenPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        FavoritesScreen(
            uiState = FavoritesUiState.Content(FavoritesPreviewData.movies),
            onBackClick = {},
            onRetryClick = {}
        )
    }
}
