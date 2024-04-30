package com.countryapp.country.ui.country_list

import com.countryapp.country.domain.model.Country

data class CountryListState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = ""
)
