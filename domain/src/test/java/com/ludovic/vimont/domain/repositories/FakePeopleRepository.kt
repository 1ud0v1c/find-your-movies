package com.ludovic.vimont.domain.repositories

import com.ludovic.vimont.domain.MockEntitiesHelper
import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.People

class FakePeopleRepository: PeopleRepository {
    companion object {
        const val PEOPLE_LIST_SIZE = 10_000
        const val GET_PEOPLE_ERROR_MESSAGE = "The profile couldn't been found..."
    }
    private val listOfPeople = ArrayList<People>()

    init {
        for (index in 1..PEOPLE_LIST_SIZE) {
            listOfPeople.add(MockEntitiesHelper.buildPeople(index))
        }
        println("listOfPeople size: ${listOfPeople.size}")
    }

    override fun get(id: Int): StateData<People> {
        val foundElement: People? = listOfPeople.find { people: People ->
            people.id == id
        }
        foundElement?.let { foundPeople: People ->
            return StateData.Success(foundPeople)
        }
        return StateData.Error(GET_PEOPLE_ERROR_MESSAGE)
    }
}
