package com.example.movieapp.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {
    private val _state = MutableStateFlow(HomeContract.State.Empty)
    val state = _state.asStateFlow()

    init {
        updateList(_state.value.filter)
    }

    private fun updateList(filter: String) {
        _state.update { it.copy(filter = filter) }
//        viewModelScope.launch {
//            val records = getRecordsUseCase.invoke(filter).getOrElse { emptyList() }
//            _state.update { currentState ->
//                val list = buildElementList(records)
//                currentState.copy(
//                    elements = list,
//                    showEmptyState = list.isEmpty()
//                )
//            }
//        }
    }



    fun onFilterChange(value: String) {
        updateList(value)
    }

    companion object {
        private const val FAVORITES_CHUNK_SIZE = 3
    }
}
