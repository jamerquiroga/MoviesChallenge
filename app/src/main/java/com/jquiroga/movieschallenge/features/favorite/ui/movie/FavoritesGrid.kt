package com.jquiroga.movieschallenge.features.favorite.ui.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jquiroga.movieschallenge.features.favorite.model.FavoriteMovieUiModel

@Composable
internal fun FavoritesGrid(
    movies: List<FavoriteMovieUiModel>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 156.dp),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = movies,
            key = { movie -> movie.id },
            contentType = { FAVORITE_MOVIE_CONTENT_TYPE },
        ) { movie ->
            FavoriteMovieCard(movie = movie)
        }
    }
}

private const val FAVORITE_MOVIE_CONTENT_TYPE = "favorite-movie"