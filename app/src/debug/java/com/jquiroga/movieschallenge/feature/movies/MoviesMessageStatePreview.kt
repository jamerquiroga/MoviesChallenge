package com.jquiroga.movieschallenge.feature.movies

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jquiroga.movieschallenge.features.home.ui.MoviesMessageState
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme

@Preview(showBackground = true, widthDp = 360, heightDp = 240)
@Composable
private fun MoviesMessageStatePreview() {
    MoviesChallengeTheme(dynamicColor = false) {
        MoviesMessageState(
            title = "Catálogo no disponible",
            message = "No pudimos obtener las películas en este momento.",
            actionLabel = "Reintentar",
            onAction = {},
        )
    }
}
