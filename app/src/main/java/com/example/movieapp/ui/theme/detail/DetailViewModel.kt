package com.example.movieapp.ui.theme.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(

):ViewModel() {

    private val _state = MutableStateFlow(DetailContract.State.Empty)
    val state = _state.asStateFlow()

    private val _similarState = MutableStateFlow(DetailContract.State.Empty)
    val similarState = _similarState.asStateFlow()

    private val _castState = MutableStateFlow(DetailContract.State.Empty)
    val castState = _castState.asStateFlow()

    fun getMovie(id:Int) {

    }

}