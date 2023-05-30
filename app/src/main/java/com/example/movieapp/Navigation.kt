package com.example.movieapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.ui.theme.detail.DetailScreen
import com.example.movieapp.ui.theme.home.ui.HomeScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = IntType
                    nullable = false
                }
            ),

        ){
            DetailScreen(id = it.arguments?.getInt("id")!!)
        }
    }
}
