package com.countryapp.country.ui.country_list


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.countryapp.common.Resource
import com.countryapp.country.domain.use_case.get_countries.GetCountriesUseCase
import com.countryapp.country.domain.use_case.get_country.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
):ViewModel(){

    private val _state = mutableStateOf(CountryListState())
    val state: State<CountryListState> = _state

    private val _query = MutableLiveData<String>()
    val query : LiveData<String> = _query

    init {
        getCountries()
    }

    fun getCountries(){
        getCountriesUseCase().onEach { result ->
            when(result){

                is Resource.Success -> {
                    _state.value = CountryListState(countries = result.data ?: emptyList())
                }

                is Resource.Error -> {

                    _state.value = CountryListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }

                is Resource.Loading  -> {
                    _state.value = CountryListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getCountry(name:String){

        getCountryUseCase(name).onEach { result ->

            when(result){
                is Resource.Success -> {
                    _state.value = CountryListState(countries = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CountryListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CountryListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onQueryChanged(query:String){
        _query.value = query
    }

}