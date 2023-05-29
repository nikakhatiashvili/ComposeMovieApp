package com.example.movieapp.ui.theme.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.movieapp.domain.search.model.MovieResult
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.home.rememberStateWithLifecycle
import com.example.movieapp.ui.theme.home.ui.Record

@Composable
fun DetailScreen(id: Int) {
    DetailScreen(id = id, viewModel = hiltViewModel())
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    id: Int,
    viewModel: DetailViewModel,
) {
    val detailState by rememberStateWithLifecycle(viewModel.state)
    val similarState by rememberStateWithLifecycle(viewModel.similarState)
    val castState by rememberStateWithLifecycle(viewModel.castState)
    viewModel.getMovie(id)
    if (detailState.elements.isNotEmpty()) {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        GlideImage(
            model = "https://image.tmdb.org/t/p/w300/" + "/yFSIUVTCvgYrpalUktulvk3Gi5Y.jpg",
            contentDescription = null,
            modifier = Modifier
                .height(LocalConfiguration.current.screenHeightDp.dp / 2).padding(top = 12.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                ),
            contentScale = ContentScale.Crop,
        )
    }

}

@Preview
@Composable
fun detailPreview() {
    MovieAppTheme() {
        DetailScreen(id = 299536)
    }
}


class DetailContract {

    data class State(
        val id: Int = -1,
        val elements: List<MovieResult> = emptyList(),
    ) {
        companion object {
            val Empty = State()
        }
    }

    sealed class ElementType {
        class Favorite(val list: List<List<Record>>) : ElementType()
        class AlignYourBody(val list: List<Record>) : ElementType()
        class AlignTourMind(val list: List<Record>) : ElementType()
    }
}