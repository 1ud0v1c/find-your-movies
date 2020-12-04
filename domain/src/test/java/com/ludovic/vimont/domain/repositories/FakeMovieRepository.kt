package com.ludovic.vimont.domain.repositories

import com.ludovic.vimont.domain.MockEntitiesHelper
import com.ludovic.vimont.domain.common.StateData
import com.ludovic.vimont.domain.entities.Genre
import com.ludovic.vimont.domain.entities.Movie

class FakeMovieRepository: MovieRepository {
    companion object {
        const val MOVIE_LIST_SIZE = 1_000
        const val GET_MOVIE_GET_ERROR_MESSAGE = "This movie couldn't been found..."
        const val GET_MOVIE_DISCOVER_ERROR_MESSAGE = "Couldn't find any movie matching the request..."
        const val MOVIE_GENRE = "action"
    }
    private val movies = ArrayList<Movie>()

    init {
        for (index in 1..MOVIE_LIST_SIZE) {
            movies.add(MockEntitiesHelper.buildMovie(index, MOVIE_GENRE))
        }
    }

    override fun get(id: Int): StateData<Movie> {
        val foundElement: Movie? = movies.find { movie: Movie ->
            movie.id == id
        }
        foundElement?.let { foundMovie: Movie ->
            return StateData.Success(foundMovie)
        }
        return StateData.Error(GET_MOVIE_GET_ERROR_MESSAGE)
    }

    override fun discover(voteAverage: Double, genres: List<Genre>): StateData<Movie> {
        val foundMovies = movies.filter {
            it.note >= voteAverage && it.genres.containsAll(genres)
        }
        if (foundMovies.isEmpty()) {
            return StateData.Error(GET_MOVIE_DISCOVER_ERROR_MESSAGE)
        }
        return StateData.Success(foundMovies.random())
    }

    override fun search(query: String): StateData<List<Movie>> {
        val foundMovies = movies.filter {
            it.title.contains(query)
        }
        return StateData.Success(foundMovies)
    }
}