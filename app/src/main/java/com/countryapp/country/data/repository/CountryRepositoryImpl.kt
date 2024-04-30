package com.countryapp.country.data.repository


import com.countryapp.country.data.remote.CountryApi
import com.countryapp.country.data.remote.dto.CountryDto
import com.countryapp.country.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api: CountryApi
): CountryRepository {
    override suspend fun getCountries(): List<CountryDto> {
        return api.getCountries()
    }
    override suspend fun getCountryByName(name: String): List<CountryDto> {
        return api.getCountryByName(name)
    }



}