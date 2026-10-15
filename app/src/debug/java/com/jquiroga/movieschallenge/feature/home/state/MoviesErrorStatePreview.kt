package com.jquiroga.movieschallenge.feature.home.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.features.home.ui.state.MoviesErrorState
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360, heightDp = 240)
@Composable
private fun MoviesErrorStatePreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesErrorState(onRetry = {})
    }
}
