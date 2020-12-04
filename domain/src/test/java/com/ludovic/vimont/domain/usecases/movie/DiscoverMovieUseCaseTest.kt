package com.ludovic.vimont.domain.usecases.movie

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Genre
import com.ludovic.vimont.domain.repositories.FakeMovieRepository
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test

class DiscoverMovieUseCaseTest {
    private val movieRepository = FakeMovieRepository()
    private val discoverMovieUseCase = DiscoverMovieUseCase(movieRepository)

    @Test
    fun testDiscoverMovie() {
        val existingGenres = ArrayList<Genre>()
        val actionGenre = Genre(1, FakeMovieRepository.MOVIE_GENRE)
        existingGenres.add(actionGenre)
        val discoverStateData = discoverMovieUseCase.execute(DiscoverMovieUseCase.DiscoverInput(5.0, existingGenres))
        Assert.assertTrue(discoverStateData is StateData.Success)
        if (discoverStateData is StateData.Success) {
            MatcherAssert.assertThat("We only wants note superior to 5.0.", discoverStateData.data.note, Matchers.greaterThan(5.0))
            Assert.assertTrue(discoverStateData.data.genres.contains(actionGenre))
        }

        val newGenres = ArrayList<Genre>()
        val surpriseGenre = Genre(2, "Lorem Ipsum")
        newGenres.add(surpriseGenre)
        val newDiscoverStateData = discoverMovieUseCase.execute(DiscoverMovieUseCase.DiscoverInput(7.0, newGenres))
        Assert.assertTrue(newDiscoverStateData is StateData.Error)
        if (newDiscoverStateData is StateData.Error) {
            Assert.assertEquals(newDiscoverStateData.errorMessage, FakeMovieRepository.GET_MOVIE_DISCOVER_ERROR_MESSAGE)
        }
    }
}