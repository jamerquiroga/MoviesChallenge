package com.jquiroga.movieschallenge.data.core.utils

object ImageUrlBuilder {
    fun poster(path: String?): String? =
        path?.let { "${ApiConfig.IMAGE_BASE_URL}${ApiConfig.POSTER_SIZE}$it" }

    fun backdrop(path: String?): String? =
        path?.let { "${ApiConfig.IMAGE_BASE_URL}${ApiConfig.BACKDROP_SIZE}$it" }
}