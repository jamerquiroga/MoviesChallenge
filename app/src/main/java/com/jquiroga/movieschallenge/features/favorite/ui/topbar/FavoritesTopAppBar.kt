package com.jquiroga.movieschallenge.features.favorite.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
internal fun FavoritesTopAppBar(
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.favorites_title))
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigate_back),
                )
            }
        },
    )
}
