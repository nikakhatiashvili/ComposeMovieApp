package com.example.movieapp.data

import com.example.movieapp.domain.ResponseHandler
import com.example.movieapp.domain.detail.DetailRepository
import com.example.movieapp.domain.detail.DetailsService
import com.example.movieapp.domain.detail.cast.DetailCast
import com.example.movieapp.domain.detail.movie.DetailMovie
import com.example.movieapp.domain.search.model.Search
import com.example.movieapp.ui.theme.detail.detailPreview
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailsService: DetailsService,
):DetailRepository {
    override suspend fun getMovieDetails(id: Int): Result<DetailMovie> {
        try {
            val response = detailsService.getMovieDetails(id)
            val body = response.body() ?: return Result.failure(Exception())
            return Result.success(body)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun getMovieCast(id: Int): Result<DetailCast> {
        try {
            val response = detailsService.getMoviesCast(id)
            val body = response.body() ?: return Result.failure(Exception())
            return Result.success(body)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}