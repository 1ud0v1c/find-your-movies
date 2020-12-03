package com.ludovic.vimont.domain.usecases.movie

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Movie
import com.ludovic.vimont.domain.repositories.MovieRepository
import com.ludovic.vimont.domain.usecases.UseCase

class GetMovieUseCase(private val movieRepository: MovieRepository): UseCase<Int, StateData<Movie>> {
    override fun execute(input: Int): StateData<Movie> {
        return movieRepository.get(input)
    }
}