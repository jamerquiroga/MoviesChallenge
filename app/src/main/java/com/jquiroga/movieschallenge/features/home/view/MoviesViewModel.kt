package com.jquiroga.movieschallenge.features.home.view

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.jquiroga.movieschallenge.features.home.model.MovieUiModel
import com.jquiroga.movieschallenge.features.home.model.MoviesUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow

class MoviesViewModel: ViewModel() {
    val uiState: StateFlow<MoviesUiState> = MutableStateFlow(MoviesUiState())

    val pagedMovies: Flow<PagingData<MovieUiModel>> = emptyFlow()
}
