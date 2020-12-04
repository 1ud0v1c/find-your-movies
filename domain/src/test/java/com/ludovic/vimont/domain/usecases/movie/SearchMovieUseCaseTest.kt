package com.ludovic.vimont.domain.usecases.movie

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.repositories.FakeMovieRepository
import org.junit.Assert
import org.junit.Test

class SearchMovieUseCaseTest {
    private val movieRepository = FakeMovieRepository()
    private val searchMovieUseCase = SearchMovieUseCase(movieRepository)

    @Test
    fun testSearchMovie() {
        val getStateData = movieRepository.get(1)
        val movieTitle = if (getStateData is StateData.Success) getStateData.data.title else ""
        val searchStateData = searchMovieUseCase.execute(movieTitle)
        Assert.assertTrue(searchStateData is StateData.Success)
        if (searchStateData is StateData.Success) {
            Assert.assertEquals(1, searchStateData.data[0].id)
        }
    }
}