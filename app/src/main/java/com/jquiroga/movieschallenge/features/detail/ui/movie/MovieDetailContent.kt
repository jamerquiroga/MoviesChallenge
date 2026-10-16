package com.jquiroga.movieschallenge.features.detail.ui.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jquiroga.movieschallenge.R
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailUiModel

@Composable
internal fun MovieDetailContent(
    movie: MovieDetailUiModel,
    favoriteUpdateFailed: Boolean,
    modifier: Modifier = Modifier
) {
    val imagePlaceholderColor = MaterialTheme.colorScheme.surfaceVariant
    val imagePlaceholder = remember(imagePlaceholderColor) {
        ColorPainter(imagePlaceholderColor)
    }

    LazyColumn(modifier = modifier.fillMaxSize()) {
        item(key = DETAIL_HERO_KEY) {
            AsyncImage(
                model = movie.heroImageUrl,
                contentDescription = stringResource(
                    R.string.movie_backdrop_content_description,
                    movie.title
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(imagePlaceholderColor),
                placeholder = imagePlaceholder,
                error = imagePlaceholder,
                fallback = imagePlaceholder,
                contentScale = ContentScale.Crop
            )
        }

        item(key = DETAIL_BODY_KEY) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                movie.tagline?.let { tagline ->
                    Text(
                        text = tagline,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontStyle = FontStyle.Italic
                    )
                }

                MovieDetailMetadata(movie = movie)

                if (favoriteUpdateFailed) {
                    Text(
                        text = stringResource(R.string.favorite_update_error),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error,
                    )
                }

                HorizontalDivider()

                Text(
                    text = stringResource(R.string.movie_overview_title),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = movie.overview.ifBlank {
                        stringResource(R.string.movie_overview_unavailable)
                    },
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

private const val DETAIL_HERO_KEY = "detail-hero"
private const val DETAIL_BODY_KEY = "detail-body"
