package com.jquiroga.movieschallenge.features.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jquiroga.movieschallenge.domain.model.Movie
import com.jquiroga.movieschallenge.domain.result.DomainResult
import com.jquiroga.movieschallenge.domain.usecase.GetMovieDetailUseCase
import com.jquiroga.movieschallenge.domain.usecase.favorite.AddFavoriteUseCase
import com.jquiroga.movieschallenge.domain.usecase.favorite.ObserveFavoriteStatusUseCase
import com.jquiroga.movieschallenge.domain.usecase.favorite.RemoveFavoriteUseCase
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
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = MovieDetailViewModel.Factory::class)
class MovieDetailViewModel @AssistedInject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val observeFavoriteStatus: ObserveFavoriteStatusUseCase,
    private val addFavorite: AddFavoriteUseCase,
    private val removeFavorite: RemoveFavoriteUseCase,
    @Assisted movieId: Long
) : ViewModel() {
    private val id = movieId
    private val _uiState = MutableStateFlow<MovieDetailUiState>(MovieDetailUiState.Loading)
    val uiState: StateFlow<MovieDetailUiState> = _uiState.asStateFlow()
    private var loadJob: Job? = null
    private var loadedMovie: Movie? = null
    private var isFavorite = false

    init {
        startObservingFavoriteStatus()
        loadMovieDetail()
    }

    fun retry() {
        loadMovieDetail()
    }

    fun onFavoriteClick() {
        val movie = loadedMovie ?: return
        val content = _uiState.value as? MovieDetailUiState.Content ?: return
        if (content.isFavoriteUpdating) return
        val targetFavoriteState = !content.isFavorite

        viewModelScope.launch {
            _uiState.updateContent { state ->
                state.copy(
                    isFavoriteUpdating = true,
                    favoriteUpdateFailed = false,
                )
            }
            val result = if (targetFavoriteState) {
                addFavorite(movie)
            } else {
                removeFavorite(movie.id)
            }
            when (result) {
                is DomainResult.Success -> {
                    isFavorite = targetFavoriteState
                    _uiState.updateContent { state ->
                        state.copy(
                            isFavorite = targetFavoriteState,
                            isFavoriteUpdating = false,
                        )
                    }
                }
                is DomainResult.Failure -> {
                    _uiState.updateContent { state ->
                        state.copy(
                            isFavoriteUpdating = false,
                            favoriteUpdateFailed = true,
                        )
                    }
                }
            }
        }
    }

    private fun startObservingFavoriteStatus() {
        viewModelScope.launch {
            observeFavoriteStatus(id)
                .catch {
                    _uiState.updateContent { state ->
                        state.copy(favoriteUpdateFailed = true)
                    }
                }
                .collect { favorite ->
                    isFavorite = favorite
                    _uiState.updateContent { state ->
                        state.copy(isFavorite = favorite)
                    }
                }
        }
    }

    private fun loadMovieDetail() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            loadedMovie = null
            _uiState.value = MovieDetailUiState.Loading
            _uiState.value = when (val result = getMovieDetailUseCase(id)) {
                is DomainResult.Success -> {
                    loadedMovie = result.value.movie
                    MovieDetailUiState.Content(
                        movie = result.value.toUiModel(),
                        isFavorite = isFavorite,
                    )
                }
                is DomainResult.Failure -> MovieDetailUiState.Error(
                    type = result.error.toMovieDetailError(),
                )
            }
        }
    }

    private inline fun MutableStateFlow<MovieDetailUiState>.updateContent(
        transform: (MovieDetailUiState.Content) -> MovieDetailUiState.Content,
    ) {
        update { state ->
            if (state is MovieDetailUiState.Content) transform(state) else state
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(movieId: Long): MovieDetailViewModel
    }
}