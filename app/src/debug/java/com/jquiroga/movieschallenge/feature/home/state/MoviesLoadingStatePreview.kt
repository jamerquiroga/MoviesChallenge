package com.jquiroga.movieschallenge.feature.home.state

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.features.home.ui.state.MoviesLoadingState
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360, heightDp = 240)
@Composable
private fun MoviesLoadingStatePreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesLoadingState(modifier = Modifier.fillMaxSize())
    }
}
