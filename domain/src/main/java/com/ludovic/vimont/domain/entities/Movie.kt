package com.ludovic.vimont.domain.entities

data class Movie(
    private val id: Int,
    private val title: String,
    private val budget: Int,
    private val cover: String,
    private val releaseDate: String,
    private val note: Double,
    private val genres: List<Genre>
)