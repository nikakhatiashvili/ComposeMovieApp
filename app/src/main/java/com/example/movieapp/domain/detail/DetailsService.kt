package com.example.movieapp.domain.detail

import com.example.movieapp.domain.Constants
import com.example.movieapp.domain.detail.cast.DetailCast
import com.example.movieapp.domain.detail.movie.DetailMovie
import com.example.movieapp.domain.detail.movie.DetailsSimilar
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsService {

    @GET(Constants.DETAILS_MOVIE)
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int,
    ): Response<DetailMovie>

    @GET(Constants.DETAILS_SIMILAR)
    suspend fun getSimilarMovies(
        @Path("movie_id") id: Int,
    ): Response<DetailsSimilar>

    @GET(Constants.DETAILS_MOVIE_CAST)
    suspend fun getMoviesCast(
        @Path("movie_id") id: Int,
    ): Response<DetailCast>
}