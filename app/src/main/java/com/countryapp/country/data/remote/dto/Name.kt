package com.countryapp.country.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("common")
    val common: String,
    @SerializedName("official")
    val official: String,
)