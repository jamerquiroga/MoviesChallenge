package com.jquiroga.movieschallenge.features.home.ui.topbar

import androidx.compose.runtime.Composable

@Composable
internal fun MoviesTopAppBar(
    searchQuery: String,
    isSearchActive: Boolean,
    onSearchClick: () -> Unit,
    onFavoritesClick: () -> Unit,
    onSearchQueryChanged: (String) -> Unit,
    onClearSearch: () -> Unit,
    onCloseSearch: () -> Unit,
) {
    if (isSearchActive) {
        MoviesSearchTopAppBar(
            searchQuery = searchQuery,
            onSearchQueryChanged = onSearchQueryChanged,
            onClearSearch = onClearSearch,
            onCloseSearch = onCloseSearch,
        )
    } else {
        MoviesCatalogTopAppBar(
            onSearchClick = onSearchClick,
            onFavoritesClick = onFavoritesClick
        )
    }
}
