package com.example.movieapp.domain

import com.example.movieapp.domain.Constants.GET_SEARCH
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET(GET_SEARCH)
    suspend fun getMoviesSearch(
        @Query("query") query: String,
    ): Response<Search>
}
