package com.ludovic.vimont.domain.usecases

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.People
import com.ludovic.vimont.domain.repositories.PeopleRepository

class GetPeopleUseCase(private val peopleRepository: PeopleRepository): UseCase<Int, StateData<People>> {
    override fun execute(input: Int): StateData<People> {
        return peopleRepository.get(input)
    }
}