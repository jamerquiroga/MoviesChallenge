package com.jquiroga.movieschallenge.feature.home.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.features.home.ui.state.MoviesAppendLoadingState
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MoviesAppendLoadingStatePreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesAppendLoadingState()
    }
}
