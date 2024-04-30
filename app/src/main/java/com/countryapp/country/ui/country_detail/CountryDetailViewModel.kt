package com.countryapp.country.ui.country_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.SavedStateHandle
import com.countryapp.common.Constants
import com.countryapp.common.Resource
import com.countryapp.country.domain.use_case.get_country.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val getCountryUseCase: GetCountryUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel(){

    private val _state = mutableStateOf(CountryDetailState())
    val state: State<CountryDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_NAME) ?.let { name ->
            getCountry(name)
        }
    }

    private fun getCountry(name:String){
        getCountryUseCase(name).onEach { result ->
            when(result){
                is Resource.Success -> {

                    _state.value = CountryDetailState(country = result.data ?: emptyList())

                }
                is Resource.Error -> {

                    _state.value = CountryDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )

                }
                is Resource.Loading -> {
                    _state.value = CountryDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}