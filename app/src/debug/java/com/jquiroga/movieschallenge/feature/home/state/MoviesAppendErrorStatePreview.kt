package com.jquiroga.movieschallenge.feature.home.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.features.home.ui.state.MoviesAppendErrorState
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MoviesAppendErrorStatePreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesAppendErrorState (onRetry = {})
    }
}
