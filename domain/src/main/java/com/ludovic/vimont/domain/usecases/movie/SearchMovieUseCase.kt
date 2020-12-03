package com.ludovic.vimont.domain.usecases.movie

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Movie
import com.ludovic.vimont.domain.repositories.MovieRepository
import com.ludovic.vimont.domain.usecases.UseCase

class SearchMovieUseCase(private val movieRepository: MovieRepository): UseCase<String, StateData<List<Movie>>> {
    override fun execute(input: String): StateData<List<Movie>> {
        return movieRepository.search(input)
    }
}