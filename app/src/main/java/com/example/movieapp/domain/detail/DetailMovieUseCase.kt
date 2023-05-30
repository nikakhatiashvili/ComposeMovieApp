package com.example.movieapp.domain.detail

import com.example.movieapp.domain.detail.cast.DetailCast
import com.example.movieapp.domain.detail.movie.DetailMovie
import javax.inject.Inject

class DetailMovieUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    suspend operator fun invoke(id: Int): Result<DetailMovie> {
        return detailRepository.getMovieDetails(id)
    }
    suspend fun getCast(id:Int):Result<DetailCast>{
        return detailRepository.getMovieCast(id)
    }
}