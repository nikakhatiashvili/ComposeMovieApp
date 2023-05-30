package com.example.movieapp.ui.theme.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.detail.DetailMovieUseCase
import com.example.movieapp.domain.search.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailMoviesUseCase: DetailMovieUseCase
):ViewModel() {



    private val _viewState = MutableStateFlow(TaskListViewState())
    val viewState = _viewState.asStateFlow()

    fun getMovie(id:Int){
        getMovieDetails(id)
        getMovieCast(id)
    }

    private fun getMovieCast(id: Int){
        viewModelScope.launch(Dispatchers.IO){
            val cast = detailMoviesUseCase.getCast(id)
            cast.onSuccess {
                _viewState.update { cr ->
                    cr.copy(
                        false,
                        cr.detailMovie,
                        it.cast,
                        null,
                        cr.similar
                    )
                }
            }
        }
    }
    private fun getMovieDetails(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val detailMovie = detailMoviesUseCase.invoke(id)
            detailMovie.onSuccess {
                _viewState.update { cr ->
                    cr.copy(
                        false,
                        it,
                        cr.cast,
                        null,
                        cr.similar
                    )
                }
            }
        }
    }

}