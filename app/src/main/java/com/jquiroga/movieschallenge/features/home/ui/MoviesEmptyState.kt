package com.jquiroga.movieschallenge.features.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jquiroga.movieschallenge.R

@Composable
internal fun MoviesEmptyState(modifier: Modifier = Modifier) {
    MoviesMessageState(
        title = stringResource(R.string.empty_catalog_title),
        message = stringResource(R.string.empty_catalog_message),
        modifier = modifier
    )
}
