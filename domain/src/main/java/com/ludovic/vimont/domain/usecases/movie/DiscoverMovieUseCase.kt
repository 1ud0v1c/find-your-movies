package com.ludovic.vimont.domain.usecases.movie

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Genre
import com.ludovic.vimont.domain.entities.Movie
import com.ludovic.vimont.domain.repositories.MovieRepository
import com.ludovic.vimont.domain.usecases.UseCase

class DiscoverMovieUseCase(private val movieRepository: MovieRepository): UseCase<DiscoverMovieUseCase.DiscoverInput, StateData<Movie>> {
    override fun execute(input: DiscoverInput): StateData<Movie> {
        return movieRepository.discover(input.voteAverage, input.genre)
    }

    class DiscoverInput(val voteAverage: Double,
                        val genre: List<Genre> = ArrayList())
}