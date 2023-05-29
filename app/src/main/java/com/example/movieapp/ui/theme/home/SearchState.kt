package com.example.movieapp.ui.theme.home

class SearchContract {

    data class State(
        val str: String = "",
        val loading: Boolean = false,
    ) {
        companion object {
            val Empty = State()
        }
    }

    sealed class Effect {
        object None : Effect()
        object SearchSuccessful : Effect()
        object SignUp : Effect()
    }
}
