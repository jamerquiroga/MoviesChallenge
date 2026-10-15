package com.jquiroga.movieschallenge.feature.detail.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailError
import com.jquiroga.movieschallenge.features.detail.ui.state.MovieDetailErrorState

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
private fun MovieDetailErrorStatePreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MovieDetailErrorState(
            error = MovieDetailError.NetworkUnavailable,
            onRetryClick = {},
        )
    }
}