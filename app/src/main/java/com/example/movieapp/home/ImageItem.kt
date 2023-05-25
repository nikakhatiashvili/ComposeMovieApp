package com.example.movieapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.ui.theme.MovieAppTheme


@Composable
fun RectangularItem(record: Record) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Row() {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = record.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = record.name,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = record.description,
                    modifier = Modifier.fillMaxWidth().fillMaxSize(),
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}

@Preview
@Composable
private fun Preview() {
    MovieAppTheme() {
        RectangularItem(record = Record("breaking bad", R.drawable.ic_launcher_background,"dasdas"))
    }
}