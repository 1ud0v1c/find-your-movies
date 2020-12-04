package com.ludovic.vimont.domain.usecases.movie

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Movie
import com.ludovic.vimont.domain.repositories.FakeMovieRepository
import org.junit.Assert
import org.junit.Test

class GetMovieUseCaseTest {
    private val movieRepository = FakeMovieRepository()
    private val getMovieUseCase = GetMovieUseCase(movieRepository)

    @Test
    fun testGetMovieById() {
        val result: StateData<Movie> = getMovieUseCase.execute(1)
        Assert.assertTrue(result is StateData.Success)
        if (result is StateData.Success) {
            Assert.assertEquals(1, result.data.id)
        }

        val newResult: StateData<Movie> = getMovieUseCase.execute(FakeMovieRepository.MOVIE_LIST_SIZE + 1)
        Assert.assertTrue(newResult is StateData.Error)
        if (newResult is StateData.Error) {
            Assert.assertEquals(FakeMovieRepository.GET_MOVIE_GET_ERROR_MESSAGE, newResult.errorMessage)
        }
    }
}