package com.jquiroga.movieschallenge.features.home.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jquiroga.movieschallenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MoviesSearchTopAppBar(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    onClearSearch: () -> Unit,
    onCloseSearch: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onCloseSearch) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.close_search),
                )
            }
        },
        title = {
            MoviesSearchField(
                searchQuery = searchQuery,
                onSearchQueryChanged = onSearchQueryChanged,
                onClearSearch = onClearSearch,
            )
        },
    )
}
