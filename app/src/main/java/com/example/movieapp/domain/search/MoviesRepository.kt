package com.example.movieapp.domain.search

import com.example.movieapp.domain.search.model.Search

interface MoviesRepository {

    suspend fun getMovies(str:String):Result<Search>
}
