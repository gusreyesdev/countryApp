package com.countryapp.country.ui.navigation

sealed class Screen(val route: String) {
    data object CountryListScreen: Screen("countryListScreen")
    data object CountryDetailScreen: Screen("countryDetailScreen")
}