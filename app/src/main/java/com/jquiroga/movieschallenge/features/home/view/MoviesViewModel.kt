package com.jquiroga.movieschallenge.features.home.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.jquiroga.movieschallenge.domain.usecase.home.GetMoviesUseCase
import com.jquiroga.movieschallenge.features.home.mapper.toUiModel
import com.jquiroga.movieschallenge.features.home.model.MovieUiModel
import com.jquiroga.movieschallenge.features.home.model.MoviesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class MoviesViewModel @Inject constructor(getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(MoviesUiState())
    val uiState: StateFlow<MoviesUiState> = _uiState.asStateFlow()

    val pagedMovies: Flow<PagingData<MovieUiModel>> = uiState
        .map { state -> state.searchQuery.trim() }
        .distinctUntilChanged()
        .debounce { query ->
            if (query.isBlank()) NO_SEARCH_DEBOUNCE else SEARCH_DEBOUNCE_MILLIS
        }
        .flatMapLatest { query -> getMoviesUseCase(query) }
        .map { pagingData ->
            pagingData.map { movie -> movie.toUiModel() }
        }
        .cachedIn(viewModelScope)

    fun onSearchQueryChanged(query: String) {
        _uiState.update { state -> state.copy(searchQuery = query) }
    }

    private companion object {
        const val NO_SEARCH_DEBOUNCE = 0L
        const val SEARCH_DEBOUNCE_MILLIS = 350L
    }
}
