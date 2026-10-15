package com.jquiroga.movieschallenge.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviePageDto(
    @SerialName("page")
    val page: Int = 1,
    @SerialName("results")
    val results: List<MovieDto> = emptyList(),
    @SerialName("total_pages")
    val totalPages: Int = 1,
    @SerialName("total_results")
    val totalResults: Int = 0
)