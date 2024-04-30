package com.countryapp.country.data.remote.dto

import com.countryapp.country.domain.model.Country
import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name")
    val name: Name?,

    @SerializedName("capital")
    val capital: List<String>?,

    @SerializedName("flags")
    val flags: Flags?,

    @SerializedName("region")
    val region:String?,

    @SerializedName("subregion")
    val subregion:String?,

    @SerializedName("population")
    val population:String?,

    @SerializedName("status")
    val status:String?,

    @SerializedName("fifa")
    val fifa:String?,



    )

fun CountryDto.toCountry(): Country {
    return Country(
        name = name,
        capital = capital,
        flags = flags,
        region = region,
        subregion = subregion,
        population = population,
        status = status,
        fifa
    )
}