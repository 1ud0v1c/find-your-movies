package com.ludovic.vimont.domain.entities

data class People(
    private val id: Int,
    private val name: String,
    private val photo: String,
    private val biography: String,
    private val birthDay: String,
    private val deathDay: String?,
    private val gender: Int,
    private val popularity: Int,
    private val profession: String
)