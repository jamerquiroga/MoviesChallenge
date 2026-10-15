package com.jquiroga.movieschallenge.features.detail.ui.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jquiroga.movieschallenge.R
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailUiModel

@Composable
internal fun MovieDetailMetadata(
    movie: MovieDetailUiModel,
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = stringResource(R.string.movie_rating, movie.voteAverage),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            movie.releaseYear?.let { year ->
                Text(
                    text = year,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            movie.runtimeMinutes?.let { runtime ->
                Text(
                    text = stringResource(R.string.movie_runtime, runtime),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        if (movie.genres.isNotBlank()) {
            Text(
                text = movie.genres,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}