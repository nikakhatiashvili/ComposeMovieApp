package com.example.movieapp.domain.search

import com.example.movieapp.domain.search.model.Search
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(filter: String): Result<Search> {
        return  moviesRepository.getMovies(filter)
    }
}
