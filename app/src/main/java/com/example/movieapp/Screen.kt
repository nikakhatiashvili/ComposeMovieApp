package com.example.movieapp

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(arg: Int): String {
        return buildString {
            append(route)
            append("/$arg")
        }
    }
}
