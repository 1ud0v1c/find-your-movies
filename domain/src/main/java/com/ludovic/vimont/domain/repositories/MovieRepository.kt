package com.ludovic.vimont.domain.repositories

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Genre
import com.ludovic.vimont.domain.entities.Movie

interface MovieRepository {
    fun get(id: Int): StateData<Movie>

    fun discover(voteAverage: Float, genres: List<Genre> = ArrayList()): StateData<Movie>

    fun search(query: String): StateData<List<Movie>>
}