package com.example.movieapp.domain

interface MoviesRepository {

    suspend fun getMovies(str:String):Result<Search>
}
