package com.example.movieapp.domain

import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(filter: String): Result<Search> {
        return  moviesRepository.getMovies(filter)
    }
}
