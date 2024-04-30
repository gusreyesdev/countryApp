package com.countryapp.country.domain.model

import com.countryapp.country.data.remote.dto.Flags
import com.countryapp.country.data.remote.dto.Name

data class Country(
    val name: Name?,
    val capital: List<String>?,
    val flags: Flags?,
    val region:String?,
    val subregion:String?,
    val population:String?,
    val status:String?,
    val fifa:String?
)
