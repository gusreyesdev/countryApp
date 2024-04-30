package com.countryapp.country.domain.use_case.get_countries


import com.countryapp.common.Resource
import com.countryapp.country.data.remote.dto.toCountry
import com.countryapp.country.domain.model.Country
import com.countryapp.country.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountryRepository
) {

    operator fun invoke(): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())

            val countries = repository.getCountries().map { it.toCountry() }
            emit(Resource.Success(countries))

        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}