package com.countryapp.country.data.di


import com.countryapp.common.Constants
import com.countryapp.country.data.remote.CountryApi
import com.countryapp.country.data.repository.CountryRepositoryImpl
import com.countryapp.country.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCountryApi(): CountryApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CountryApi): CountryRepository {
        return CountryRepositoryImpl(api)
    }

}