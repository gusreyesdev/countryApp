package com.countryapp.country.domain.repository


import com.countryapp.country.data.remote.dto.CountryDto

interface CountryRepository {

    suspend fun getCountries(): List<CountryDto>

    suspend fun getCountryByName(name: String): List<CountryDto>
}