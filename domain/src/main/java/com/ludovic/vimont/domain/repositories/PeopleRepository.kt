package com.ludovic.vimont.domain.repositories

import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.People

interface PeopleRepository {
    fun get(id: Int): StateData<People>
}