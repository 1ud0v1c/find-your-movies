package com.ludovic.vimont.domain.entities

data class People(
    val id: Int,
    val name: String,
    val photo: String,
    val biography: String,
    val birthDay: String,
    val deathDay: String?,
    val gender: Int,
    val popularity: Int,
    val profession: String
)