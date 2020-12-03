package com.ludovic.vimont.domain.repositories

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Genre

interface GenreRepository {
    fun list(): StateData<List<Genre>>
}