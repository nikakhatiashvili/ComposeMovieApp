package com.example.movieapp.ui.theme.home.ui

import android.util.Log.d
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Screen
import com.example.movieapp.domain.search.model.MovieResult

@Composable
fun SingleRectangularCarousel(records: List<MovieResult>, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(start = 16.dp, end = 8.dp,top = 8.dp, bottom = 12.dp)
    ) {
        items(records) { record ->
            RectangularItem(record) {
                navController.navigate(Screen.DetailScreen.withArgs(it))
            }
        }
    }
}
