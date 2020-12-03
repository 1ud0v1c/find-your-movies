package com.ludovic.vimont.domain.entities

data class Movie(
    val id: Int,
    val title: String,
    val budget: Int,
    val cover: String,
    val releaseDate: String,
    val note: Double,
    val genres: List<Genre>
)