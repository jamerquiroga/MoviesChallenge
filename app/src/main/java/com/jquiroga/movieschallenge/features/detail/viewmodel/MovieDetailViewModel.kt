package com.jquiroga.movieschallenge.features.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jquiroga.movieschallenge.domain.result.DomainResult
import com.jquiroga.movieschallenge.domain.usecase.GetMovieDetailUseCase
import com.jquiroga.movieschallenge.features.detail.mapper.toMovieDetailError
import com.jquiroga.movieschallenge.features.detail.mapper.toUiModel
import com.jquiroga.movieschallenge.features.detail.model.MovieDetailUiState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = MovieDetailViewModel.Factory::class)
class MovieDetailViewModel @AssistedInject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    @Assisted movieId: Long,
) : ViewModel() {
    private val id = movieId
    private val _uiState = MutableStateFlow<MovieDetailUiState>(MovieDetailUiState.Loading)
    val uiState: StateFlow<MovieDetailUiState> = _uiState.asStateFlow()
    private var loadJob: Job? = null

    init {
        loadMovieDetail()
    }

    fun retry() {
        loadMovieDetail()
    }

    private fun loadMovieDetail() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            _uiState.value = MovieDetailUiState.Loading
            _uiState.value = when (val result = getMovieDetailUseCase(id)) {
                is DomainResult.Success -> MovieDetailUiState.Content(result.value.toUiModel())
                is DomainResult.Failure -> MovieDetailUiState.Error(
                    type = result.error.toMovieDetailError()
                )
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(movieId: Long): MovieDetailViewModel
    }
}