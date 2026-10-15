package com.jquiroga.movieschallenge.features.home.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jquiroga.movieschallenge.R

@Composable
internal fun MoviesEmptyState(
    searchQuery: String,
    modifier: Modifier = Modifier,
) {
    val isSearchResult = searchQuery.isNotBlank()

    MoviesMessageState(
        title = stringResource(
            if (isSearchResult) R.string.empty_search_title else R.string.empty_catalog_title,
        ),
        message = if (isSearchResult) {
            stringResource(R.string.empty_search_message, searchQuery.trim())
        } else {
            stringResource(R.string.empty_catalog_message)
        },
        modifier = modifier,
    )
}
