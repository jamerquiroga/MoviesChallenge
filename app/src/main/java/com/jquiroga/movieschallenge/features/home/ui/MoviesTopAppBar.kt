package com.jquiroga.movieschallenge.features.home.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jquiroga.movieschallenge.R
import com.jquiroga.movieschallenge.features.home.model.MovieCatalog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MoviesTopAppBar(
    catalog: MovieCatalog
) {
    TopAppBar(
        title = {
            Text(
                text = when (catalog) {
                    MovieCatalog.Popular -> stringResource(R.string.popular_movies_title)
                },
            )
        }
    )
}
