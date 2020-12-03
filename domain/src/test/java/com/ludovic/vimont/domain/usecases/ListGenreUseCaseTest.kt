package com.ludovic.vimont.domain.usecases

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.repositories.FakeGenreRepository
import org.junit.Assert
import org.junit.Test

class ListGenreUseCaseTest {
    private val genreRepository = FakeGenreRepository()
    private val listGenreUseCase = ListGenreUseCase(genreRepository)

    @Test
    fun testList() {
        val stateData = listGenreUseCase.execute(false)
        Assert.assertTrue(stateData is StateData.Success)
        if (stateData is StateData.Success) {
            Assert.assertTrue(stateData.data.isNotEmpty())
            Assert.assertTrue(stateData.data[0].name.isNotEmpty())
        }
    }
}