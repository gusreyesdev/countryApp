package com.countryapp.country.ui.country_detail

import com.countryapp.country.domain.model.Country

data class CountryDetailState(
    val isLoading: Boolean = false,
    val country: List<Country> = emptyList(),
    val error: String = ""
)
