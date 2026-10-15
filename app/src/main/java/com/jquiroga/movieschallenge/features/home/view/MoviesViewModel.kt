package com.jquiroga.movieschallenge.features.home.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.jquiroga.movieschallenge.domain.usecase.GetMoviesUseCase
import com.jquiroga.movieschallenge.features.home.mapper.toUiModel
import com.jquiroga.movieschallenge.features.home.model.MovieUiModel
import com.jquiroga.movieschallenge.features.home.model.MoviesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    val uiState: StateFlow<MoviesUiState> = MutableStateFlow(MoviesUiState())

    val pagedMovies: Flow<PagingData<MovieUiModel>> = getMoviesUseCase(query = "")
        .map { pagingData ->
            pagingData.map { movie -> movie.toUiModel() }
        }
        .cachedIn(viewModelScope)
}
