package com.example.movieapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieapp.R
import com.example.movieapp.domain.MovieResult

@Composable
fun HomeScreen() {
    HomeScreen(viewModel = hiltViewModel())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    val viewState by rememberStateWithLifecycle(viewModel.state)
    Scaffold(modifier) {
        Column(modifier.padding(it)) {
            Search(
                state = viewState,
                modifier = Modifier.wrapContentHeight(),
                onSearchChanged = { viewModel.onFilterChange(it) }
            )

        }


    }
}

@Composable
fun FavoriteCollectionsSection(recordLists: List<MovieResult>) {
    Text(
        text = stringResource(id = R.string.search_results).uppercase(),
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier
            .paddingFromBaseline(40.dp)
            .padding(horizontal = 16.dp)
    )
    SingleRectangularCarousel(records = recordLists)
}

@Composable
fun Search(
    state: HomeContract.State,
    modifier: Modifier = Modifier,
    onSearchChanged: (String) -> Unit = {}
) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        val focusManager = LocalFocusManager.current

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            MyTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                labelResource = R.string.search,
                value = state.filter,
                leadingIcon = Icons.Default.Search,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                onValueChange = onSearchChanged
            )

            if (state.showEmptyState || state.filter.isEmpty()) {
                EmptyState()
            } else {
                ElementsList(state)
            }
        }
    }
}

@Composable
private fun EmptyState() {
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
private fun ElementsList(state: HomeContract.State) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
            FavoriteCollectionsSection(recordLists = state.elements)
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
