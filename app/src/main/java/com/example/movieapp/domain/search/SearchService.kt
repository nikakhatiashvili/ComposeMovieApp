package com.example.movieapp.domain.search

import com.example.movieapp.domain.Constants.GET_SEARCH
import com.example.movieapp.domain.search.model.Search
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET(GET_SEARCH)
    suspend fun getMoviesSearch(
        @Query("query") query: String,
    ): Response<Search>
}
