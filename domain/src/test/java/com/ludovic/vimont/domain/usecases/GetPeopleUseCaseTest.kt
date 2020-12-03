package com.ludovic.vimont.domain.usecases

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.People
import com.ludovic.vimont.domain.repositories.FakePeopleRepository
import org.junit.Assert
import org.junit.Test

class GetPeopleUseCaseTest {
    private val peopleRepository = FakePeopleRepository()
    private val getPeopleUseCase = GetPeopleUseCase(peopleRepository)

    @Test
    fun testGetPeopleById() {
        val result: StateData<People> = getPeopleUseCase.execute(1)
        Assert.assertTrue(result is StateData.Success)
        if (result is StateData.Success) {
            Assert.assertEquals(1, result.data.id)
        }

        val newResult: StateData<People> = getPeopleUseCase.execute(FakePeopleRepository.PEOPLE_LIST_SIZE + 1)
        Assert.assertTrue(newResult is StateData.Error)
        if (newResult is StateData.Error) {
            Assert.assertEquals(FakePeopleRepository.GET_PEOPLE_ERROR_MESSAGE, newResult.errorMessage)
        }
    }
}