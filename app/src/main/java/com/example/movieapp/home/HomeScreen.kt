package com.example.movieapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieapp.R
import com.example.movieapp.ui.theme.MovieAppTheme

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
fun FavoriteCollectionsSection(recordLists: List<Record>) {
    Text(
        text = stringResource(id = R.string.favorite_collections).uppercase(),
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

            FavoriteCollectionsSection(
                recordLists = listOf(
                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),
                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),
                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),
                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),
                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),
                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),
                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),
                    Record(
                        "Breaking bad",
                        R.drawable.ic_launcher_background,
                        "Created by Vince Gilligan, the series follows the exploits " +
                                "of Walter White, a modest high school chemistry teacher, who discovers " +
                                "a new purpose in life" +
                                " when he learns he has terminal cancer and turns to a l" +
                                "ife of crime to provide for his family."
                    ),
                )
            )
        }
    }
}

@Composable
private fun EmptyState() {
//   Box(modifier = Modifier.fillMaxSize()) {
//        Text(
//            text = stringResource(id = R.string.empty_search),
//            modifier = Modifier
//                .padding(48.dp)
//                .align(Alignment.Center),
//            textAlign = TextAlign.Center,
//        )
//  }
}

@Preview
@Composable
private fun Preview() {
    MovieAppTheme() {
        FavoriteCollectionsSection(
            recordLists = listOf(

                Record(
                    "name",
                    R.drawable.ic_launcher_background,
                    "Created by Vince Gilligan, the series follows the exploits " +
                            "of Walter White, a modest high school chemistry teacher, who discovers " +
                            "a new purpose in life" +
                            " when he learns he has terminal cancer and turns to a l" +
                            "ife of crime to provide for his family."
                ),
                Record(
                    "name",
                    R.drawable.ic_launcher_background,
                    "Created by Vince Gilligan, the series follows the exploits " +
                            "of Walter White, a modest high school chemistry teacher, who discovers " +
                            "a new purpose in life" +
                            " when he learns he has terminal cancer and turns to a l" +
                            "ife of crime to provide for his family."
                ),
            )
        )
    }
}

@Composable
private fun ElementsList(state: HomeContract.State) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
//        state.elements.forEach { element ->
//            when (element) {
//                is HomeContract.ElementType.Favorite -> FavoriteCollectionsSection(recordLists = element.list)
//                is HomeContract.ElementType.AlignYourBody -> AlignYourBodySection(records = element.list)
//                is HomeContract.ElementType.AlignTourMind -> AlignYourMindSection(records = element.list)
//            }
//        }
    }
}


class HomeContract {

    data class State(
        val filter: String = "",
        val elements: List<ElementType> = emptyList(),
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
