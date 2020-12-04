package com.ludovic.vimont.domain

import com.ludovic.vimont.domain.entities.Genre
import com.ludovic.vimont.domain.entities.Movie
import com.ludovic.vimont.domain.entities.People
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.random.nextInt

object MockEntitiesHelper {
    fun buildGenre(index: Int,
                   name: String = UUID.randomUUID().toString()): Genre {
        return Genre(index, name)
    }

    fun buildPeople(index: Int,
                    name: String = UUID.randomUUID().toString(),
                    deathDay: String? = null): People {
        return People(
            index, name,
            UUID.randomUUID().toString(),
            "",
            "",
            deathDay,
            Random.nextInt(1..10_500),
            Random.nextInt(1..10_500),
            "acting"
        )
    }

    fun buildMovie(index: Int,
                   genreName: String): Movie {
        val genres = ArrayList<Genre>()
        genres.add(buildGenre(1, genreName))
        return Movie(
            index,
            UUID.randomUUID().toString(),
            Random.nextInt(100_000_000),
            UUID.randomUUID().toString(),
            "",
            Random.nextDouble(10.0),
            genres
        )
    }
}