package com.countryapp.country.domain.use_case.get_country


import com.countryapp.common.Resource
import com.countryapp.country.data.remote.dto.toCountry
import com.countryapp.country.domain.model.Country
import com.countryapp.country.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val repository: CountryRepository
) {

    operator fun invoke(name:String): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())

            val country = repository.getCountryByName(name).map { it.toCountry() }
            emit(Resource.Success(country))

        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}