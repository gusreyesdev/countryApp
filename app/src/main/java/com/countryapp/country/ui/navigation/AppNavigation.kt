package com.countryapp.country.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.countryapp.country.ui.country_detail.CountryDetailScreen
import com.countryapp.country.ui.country_list.CountryListScreen

@Composable
fun AppNavigationGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CountryListScreen.route
    ) {
        composable(
            route = Screen.CountryListScreen.route
        ) {
            CountryListScreen(navController)
        }

        composable(
            route = Screen.CountryDetailScreen.route + "/{name}"
        ) {
            CountryDetailScreen()
        }

    }
    
}