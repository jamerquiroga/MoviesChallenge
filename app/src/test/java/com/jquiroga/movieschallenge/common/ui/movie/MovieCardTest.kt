package com.jquiroga.movieschallenge.common.ui.movie

import android.content.Context
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.test.core.app.ApplicationProvider
import com.jquiroga.movieschallenge.R
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [35])
class MovieCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `Given an onClick when movie card is displayed then shows content and handles click`() {
        var wasClicked = false
        val context = ApplicationProvider.getApplicationContext<Context>()
        val expectedRating = context.getString(R.string.movie_rating, VOTE_AVERAGE)

        composeTestRule.setContent {
            MoviesChallengeTheme(dynamicColor = false) {
                MovieCard(
                    title = MOVIE_TITLE,
                    posterUrl = null,
                    releaseYear = RELEASE_YEAR,
                    voteAverage = VOTE_AVERAGE,
                    modifier = Modifier.width(180.dp),
                    onClick = { wasClicked = true },
                )
            }
        }

        composeTestRule.onNodeWithText(MOVIE_TITLE).assertIsDisplayed()
        composeTestRule.onNodeWithText(RELEASE_YEAR).assertIsDisplayed()
        composeTestRule.onNodeWithText(expectedRating).assertIsDisplayed()
        composeTestRule.onNode(hasClickAction()).performClick()

        composeTestRule.runOnIdle {
            assertTrue(wasClicked)
        }
    }

    @Test
    fun `Given no onClick when movie card is displayed then card is not clickable`() {
        composeTestRule.setContent {
            MoviesChallengeTheme(dynamicColor = false) {
                MovieCard(
                    title = MOVIE_TITLE,
                    posterUrl = null,
                    releaseYear = RELEASE_YEAR,
                    voteAverage = VOTE_AVERAGE,
                    modifier = Modifier.width(180.dp),
                )
            }
        }

        composeTestRule.onNodeWithText(MOVIE_TITLE).assertIsDisplayed()
        composeTestRule.onAllNodes(hasClickAction()).assertCountEquals(0)
    }

    private companion object {
        const val MOVIE_TITLE = "The Matrix"
        const val RELEASE_YEAR = "1999"
        const val VOTE_AVERAGE = 8.2
    }
}
