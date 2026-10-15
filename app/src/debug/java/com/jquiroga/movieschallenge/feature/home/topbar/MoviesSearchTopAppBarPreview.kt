package com.jquiroga.movieschallenge.feature.home.topbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.features.home.ui.topbar.MoviesSearchTopAppBar

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MoviesSearchTopAppBarPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesSearchTopAppBar(
            searchQuery = "Matrix",
            onSearchQueryChanged = {},
            onClearSearch = {},
            onCloseSearch = {}
        )
    }
}
