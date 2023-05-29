package com.example.movieapp.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.movieapp.domain.MovieResult

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RectangularItem(record: MovieResult) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
    ) {
        Row() {
            GlideImage(
                modifier = Modifier.height(120.dp).width(90.dp),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                model = "https://image.tmdb.org/t/p/original/" + record.poster_path,

            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = record.title.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = record.overview.orEmpty(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize(),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
