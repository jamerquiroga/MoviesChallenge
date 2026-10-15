package com.jquiroga.movieschallenge.feature.favorite.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.features.favorite.ui.state.FavoritesLoadingState

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
private fun FavoritesLoadingStatePreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        FavoritesLoadingState()
    }
}
