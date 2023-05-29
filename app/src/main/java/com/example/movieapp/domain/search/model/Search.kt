package com.example.movieapp.domain.search.model

import com.example.movieapp.domain.search.model.MovieResult

data class Search(
    val page: Int?,
    val results: List<MovieResult>?,
    val total_pages: Int?,
    val total_results: Int?
)
