package com.countryapp.country.ui.country_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.countryapp.country.ui.navigation.Screen
import com.countryapp.country.ui.country_list.components.CountryListItem
import com.countryapp.country.ui.country_list.components.SearchTextField
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun CountryListScreen(
    navController: NavController,
    viewModel: CountryListViewModel = hiltViewModel()
) {

    val query: String by viewModel.query.observeAsState(initial = "")
    val state = viewModel.state.value

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = viewModel.state.value.isLoading)

    Column {

        SearchTextField( query ) {
            viewModel.onQueryChanged(it)
            viewModel.getCountry(query)
        }

        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = viewModel::getCountries,
        ) {
            LazyColumn {
                items(state.countries) { country ->
                    CountryListItem(
                        country = country,
                        onItemClick = {
                            navController.navigate(
                                Screen.CountryDetailScreen.route + "/${country.name?.official}"
                            )
                        }
                    )
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }

    }

}
