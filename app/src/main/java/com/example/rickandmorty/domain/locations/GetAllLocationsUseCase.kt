package com.example.rickandmorty.domain.locations

import androidx.lifecycle.LiveData

class GetAllLocationsUseCase(private val locationsRepository: LocationsRepository) {
    fun getAllLocations(): LiveData<List<LocationObject>> {
        return locationsRepository.getAllLocations()
    }
}