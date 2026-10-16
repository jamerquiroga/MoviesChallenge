package com.jquiroga.movieschallenge.features.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jquiroga.movieschallenge.domain.result.DomainResult
import com.jquiroga.movieschallenge.domain.usecase.favorite.GetFavoriteMoviesUseCase
import com.jquiroga.movieschallenge.features.favorite.mapper.toFavoriteUiModel
import com.jquiroga.movieschallenge.features.favorite.model.FavoritesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteMovies: GetFavoriteMoviesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<FavoritesUiState>(FavoritesUiState.Loading)
    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()
    private var loadJob: Job? = null

    init {
        loadFavorites()
    }

    fun retry() {
        loadFavorites()
    }

    private fun loadFavorites() {
        loadJob?.cancel()
        _uiState.value = FavoritesUiState.Loading
        loadJob = viewModelScope.launch {
            _uiState.value = when (val result = getFavoriteMovies()) {
                is DomainResult.Success -> {
                    val favorites = result.value
                    if (favorites.isEmpty()) {
                        FavoritesUiState.Empty
                    } else {
                        FavoritesUiState.Content(
                            movies = favorites.map { movie -> movie.toFavoriteUiModel() },
                        )
                    }
                }
                is DomainResult.Failure -> FavoritesUiState.Error
            }
        }
    }
}
