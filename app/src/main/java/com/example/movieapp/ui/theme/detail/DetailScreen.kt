package com.example.movieapp.ui.theme.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.movieapp.R
import com.example.movieapp.domain.detail.cast.Cast
import com.example.movieapp.domain.detail.cast.DetailCast
import com.example.movieapp.domain.detail.movie.DetailMovie
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.home.ui.Record

@Composable
fun DetailScreen(id: Int) {
    DetailScreen(id = id, viewModel = hiltViewModel())
}

@Composable
fun DetailScreen(
    id: Int,
    viewModel: DetailViewModel,
) {
    viewModel.getMovie(id)
    val viewState = viewModel.viewState.collectAsState()

    DetailMovieScreen(state = viewState.value)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailMovieScreen(state: TaskListViewState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
    ) {
        GlideImage(
            model = "https://image.tmdb.org/t/p/w300/" + state.detailMovie?.poster_path,
            contentDescription = null,
            modifier = Modifier
                .height(LocalConfiguration.current.screenHeightDp.dp / 2)
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
        Text(
            text = state.detailMovie?.title.toString(),
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            fontStyle = FontStyle.Normal,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = state.detailMovie?.overview.toString(),
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            fontStyle = FontStyle.Normal,
            color = MaterialTheme.colorScheme.primary
        )
        Cast(state = state)
    }
}

@Composable
fun Cast(
    state: TaskListViewState
) {
    Column(
    ) {
        Text(
            text = stringResource(id = R.string.cast).uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .paddingFromBaseline(40.dp)
                .padding(horizontal = 16.dp)
        )
        CastItem(state)
    }
}

@Composable
fun CastItem(state: TaskListViewState) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 12.dp)
    ) {
        if (state.cast != null) {
            items(state.cast) { record ->
                CastImageItem(record)
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CastImageItem(cast: Cast) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .wrapContentSize()
    ) {
        Column {
            GlideImage(
                modifier = Modifier
                    .height(120.dp)
                    .width(90.dp),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                model = "https://image.tmdb.org/t/p/original/" + cast.profile_path,
                )
        }
    }
}

@Preview
@Composable
fun detailPreview() {
    MovieAppTheme() {
        DetailScreen(id = 299536)
    }
}
