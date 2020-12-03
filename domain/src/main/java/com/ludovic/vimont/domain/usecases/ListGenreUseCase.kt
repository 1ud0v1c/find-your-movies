package com.ludovic.vimont.domain.usecases

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Genre
import com.ludovic.vimont.domain.repositories.GenreRepository

class ListGenreUseCase(private val genreRepository: GenreRepository): UseCase<Boolean, StateData<List<Genre>>> {
    override fun execute(input: Boolean): StateData<List<Genre>> {
        return genreRepository.list()
    }
}