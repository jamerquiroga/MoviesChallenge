package com.jquiroga.movieschallenge.feature.movies

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.features.home.ui.MoviesEmptyState
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360, heightDp = 240)
@Composable
private fun MoviesEmptyStatePreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesEmptyState()
    }
}
