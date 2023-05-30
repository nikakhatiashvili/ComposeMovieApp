package com.example.movieapp.ui.theme.detail

import com.example.movieapp.domain.detail.cast.Cast
import com.example.movieapp.domain.detail.movie.DetailMovie
import java.time.LocalDate
import java.time.format.DateTimeFormatter


data class TaskListViewState(
    val showLoading: Boolean = true,
    val detailMovie: DetailMovie? = null,
    val cast: List<Cast>? = null,
    val errorMessage: String? = null,
    val similar: List<DetailMovie>? = null,
) {
    
    val showTasks: Boolean
        get() = !showLoading && errorMessage == null


    companion object {
        const val DATE_HEADER_FORMAT = "MMM d"
    }
}
