package com.example.movieapp.ui.theme.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.R

@Composable
fun Search(
    state: HomeContract.State,
    modifier: Modifier = Modifier,
    onSearchChanged: (String) -> Unit = {},
    navController: NavController
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
                ElementsList(state,navController)
            }
        }
    }
}
