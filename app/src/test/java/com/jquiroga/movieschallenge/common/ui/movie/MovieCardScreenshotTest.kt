package com.jquiroga.movieschallenge.common.ui.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.takahirom.roborazzi.captureRoboImage
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [35])
class MovieCardScreenshotTest {

    @Test
    fun `Movie card matches golden in light theme`() {
        captureMovieCard(
            darkTheme = false,
            fileName = "movie_card_light.png",
        )
    }

    @Test
    fun `Movie card matches golden in dark theme`() {
        captureMovieCard(
            darkTheme = true,
            fileName = "movie_card_dark.png",
        )
    }

    private fun captureMovieCard(
        darkTheme: Boolean,
        fileName: String,
    ) {
        captureRoboImage(fileName) {
            MoviesChallengeTheme(
                darkTheme = darkTheme,
                dynamicColor = false,
            ) {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(8.dp),
                ) {
                    MovieCard(
                        title = MOVIE_TITLE,
                        posterUrl = null,
                        releaseYear = RELEASE_YEAR,
                        voteAverage = VOTE_AVERAGE,
                        modifier = Modifier.width(180.dp),
                    )
                }
            }
        }
    }

    private companion object {
        const val MOVIE_TITLE = "The Matrix"
        const val RELEASE_YEAR = "1999"
        const val VOTE_AVERAGE = 8.2
    }
}
