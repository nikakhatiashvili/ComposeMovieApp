package com.example.movieapp.ui.theme.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movieapp.R
import com.example.movieapp.domain.search.model.MovieResult
import com.example.movieapp.ui.theme.home.HomeViewModel
import com.example.movieapp.ui.theme.home.rememberStateWithLifecycle

@Composable
fun HomeScreen(navController: NavController) {
    HomeScreen(viewModel = hiltViewModel(), navController = navController)
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    navController: NavController
) {
    val viewState by rememberStateWithLifecycle(viewModel.state)
    Scaffold(modifier) {
        Column(modifier.padding(it)) {
            Search(
                state = viewState,
                modifier = Modifier.wrapContentHeight(),
                onSearchChanged = { viewModel.onFilterChange(it) },
                navController = navController
            )

        }


    }
}

@Composable
fun FavoriteCollectionsSection(recordLists: List<MovieResult>, navController: NavController) {
    Text(
        text = stringResource(id = R.string.search_results).uppercase(),
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier
            .paddingFromBaseline(40.dp)
            .padding(horizontal = 16.dp)
    )
    SingleRectangularCarousel(records = recordLists,navController)
}


@Composable
fun EmptyState() {
   Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.empty_search),
            modifier = Modifier
                .padding(48.dp)
                .align(Alignment.Center),
            textAlign = TextAlign.Center,
        )
  }
}

@Preview
@Composable
private fun Preview() {
}

@Composable
fun ElementsList(state: HomeContract.State, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
            FavoriteCollectionsSection(recordLists = state.elements,navController)
    }
}


class HomeContract {

    data class State(
        val filter: String = "",
        val elements: List<MovieResult> = emptyList(),
        val showEmptyState: Boolean = true,
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

data class Record(
    val name: String,
    val imageRes: Int,
    val description: String,
)
