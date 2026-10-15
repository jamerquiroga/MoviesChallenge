package com.jquiroga.movieschallenge.features.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import com.jquiroga.movieschallenge.features.home.model.MovieUiModel

@Composable
internal fun MovieGrid(
    movies: LazyPagingItems<MovieUiModel>,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 156.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                count = movies.itemCount,
                key = { index ->
                    movies.peek(index)?.let { movie -> "${movie.id}_$index" } ?: index
                },
                contentType = movies.itemContentType { MOVIE_CONTENT_TYPE },
            ) { index ->
                movies[index]?.let { movie ->
                    MovieCard(movie = movie)
                }
            }

            when (movies.loadState.append) {
                is LoadState.Loading -> {
                    item(
                        key = APPEND_LOADING_KEY,
                        span = { GridItemSpan(maxLineSpan) }
                    ) {
                        MoviesAppendLoadingState()
                    }
                }

                is LoadState.Error -> {
                    item(
                        key = APPEND_ERROR_KEY,
                        span = { GridItemSpan(maxLineSpan) }
                    ) {
                        MoviesAppendErrorState(onRetry = movies::retry)
                    }
                }

                is LoadState.NotLoading -> Unit
            }
        }

        if (movies.loadState.refresh is LoadState.Loading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            )
        }
    }
}

private const val MOVIE_CONTENT_TYPE = "movie"
private const val APPEND_LOADING_KEY = "append-loading"
private const val APPEND_ERROR_KEY = "append-error"
