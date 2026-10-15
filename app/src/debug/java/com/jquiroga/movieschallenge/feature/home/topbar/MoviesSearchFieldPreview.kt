package com.jquiroga.movieschallenge.feature.home.topbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.features.home.ui.topbar.MoviesSearchField

@Preview(showBackground = true, widthDp = 304)
@Composable
private fun MoviesSearchFieldPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesSearchField(
            searchQuery = "Matrix",
            onSearchQueryChanged = {},
            onClearSearch = {}
        )
    }
}
