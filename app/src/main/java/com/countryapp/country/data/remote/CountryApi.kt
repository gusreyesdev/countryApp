package com.countryapp.country.data.remote

import com.countryapp.country.data.remote.dto.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {

    @GET("v3.1/all")
    suspend fun getCountries(): List<CountryDto>

    @GET("v3.1/name/{name}")
    suspend fun getCountryByName(@Path("name") name:String): List<CountryDto>

}