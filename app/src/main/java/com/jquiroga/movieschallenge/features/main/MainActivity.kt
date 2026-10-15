package com.jquiroga.movieschallenge.features.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jquiroga.movieschallenge.features.home.route.MoviesRoute
import com.jquiroga.movieschallenge.core.theme.MoviesChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesChallengeTheme {
                MoviesRoute()
            }
        }
    }
}