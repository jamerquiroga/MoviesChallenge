package com.jquiroga.movieschallenge.feature.movies

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.features.home.model.MovieCatalog
import com.jquiroga.movieschallenge.features.home.ui.MoviesTopAppBar
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MoviesTopAppBarPreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesTopAppBar(catalog = MovieCatalog.Popular)
    }
}
