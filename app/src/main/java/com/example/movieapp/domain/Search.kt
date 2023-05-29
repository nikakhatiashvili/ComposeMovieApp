package com.example.movieapp.domain

data class Search(
    val page: Int?,
    val results: List<MovieResult>?,
    val total_pages: Int?,
    val total_results: Int?
)
