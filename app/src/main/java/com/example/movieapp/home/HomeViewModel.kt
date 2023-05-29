package com.example.movieapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.GetMoviesUseCase
import com.example.movieapp.home.ui.HomeContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeContract.State.Empty)
    val state = _state.asStateFlow()

    init {
        updateList(_state.value.filter)
    }

    private fun updateList(filter: String) {
        _state.update { it.copy(filter = filter) }
        viewModelScope.launch {
            val records = getMoviesUseCase.invoke(filter)
            records.onSuccess {
                _state.update { currentState ->
                    currentState.copy(
                        elements = it.results!!,
                        showEmptyState = it.results.isEmpty()
                    )
                }
            }
        }
    }

    fun onFilterChange(value: String) {
        updateList(value)
    }
}
