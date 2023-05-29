package com.example.movieapp.domain.detail

import com.example.movieapp.domain.detail.movie.SimilarResults

data class DetailsSimilar(
    val page: Int?,
    val results: List<SimilarResults>?,
    val total_pages: Int?,
    val total_results: Int?
)