package com.ludovic.vimont.domain.repositories

import com.ludovic.vimont.domain.MockEntitiesHelper
import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Genre

class FakeGenreRepository: GenreRepository {
    companion object {
        const val GENRE_LIST_SIZE = 20
    }

    override fun list(): StateData<List<Genre>> {
        val list = ArrayList<Genre>()
        for (index in 0..GENRE_LIST_SIZE) {
            list.add(MockEntitiesHelper.buildGenre(index))
        }
        return StateData.Success(list)
    }
}