package com.example.movieapp.data

import com.example.movieapp.domain.MoviesRepository
import com.example.movieapp.domain.Search
import com.example.movieapp.domain.SearchService
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val searchService: SearchService
):MoviesRepository {
    override suspend fun getMovies(str: String): Result<Search> {
        try {
            val response = searchService.getMoviesSearch(str)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                return Result.success(body)
            }
            return Result.success(Search(0, emptyList(),1,1))
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}
