package com.jquiroga.movieschallenge.data.core.utils.time

import javax.inject.Inject

interface TimeProvider {
    fun currentTimeMillis(): Long
}

class SystemTimeProvider @Inject constructor() : TimeProvider {

    override fun currentTimeMillis(): Long {
        return System.currentTimeMillis()
    }
}