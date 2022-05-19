package com.example.rickandmorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.locations.GetSingleLocationUseCase
import com.example.rickandmorty.domain.locations.LocationObject
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    private val repository = LocationsRepositoryImpl
    private val getSingleLocationUseCase = GetSingleLocationUseCase(repository)

    val location = MutableLiveData<LocationObject>()

    fun getSingleLocation(itemId: Int) {
        viewModelScope.launch {
            val item = getSingleLocationUseCase.getSingleLocation(itemId)
            location.value = item
        }
    }
}