package com.jquiroga.movieschallenge.features.home.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jquiroga.movieschallenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MoviesCatalogTopAppBar(
    onSearchClick: () -> Unit,
    onFavoritesClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.popular_movies_title))
        },
        actions = {
            IconButton(onClick = onFavoritesClick) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = stringResource(R.string.open_favorites),
                )
            }
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_movies),
                )
            }
        },
    )
}