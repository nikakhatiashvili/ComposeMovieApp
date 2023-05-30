package com.example.movieapp.domain.detail

import com.example.movieapp.domain.detail.cast.DetailCast
import com.example.movieapp.domain.detail.movie.DetailMovie

interface DetailRepository {

    suspend fun getMovieDetails(id:Int):Result<DetailMovie>

    suspend fun getMovieCast(id:Int):Result<DetailCast>
}
