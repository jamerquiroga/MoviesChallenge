package com.jquiroga.movieschallenge.feature.home.topbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import com.jquiroga.movieschallenge.features.home.ui.topbar.MoviesTopAppBar

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MoviesTopAppBarPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesTopAppBar(
            searchQuery = "",
            isSearchActive = false,
            onSearchClick = {},
            onSearchQueryChanged = {},
            onClearSearch = {},
            onCloseSearch = {},
            onFavoritesClick = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MoviesTopAppBarSearchPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesTopAppBar(
            searchQuery = "Matrix",
            isSearchActive = true,
            onSearchClick = {},
            onSearchQueryChanged = {},
            onClearSearch = {},
            onCloseSearch = {},
            onFavoritesClick = {}
        )
    }
}
