package com.example.rickandmorty.domain.locations

import androidx.lifecycle.LiveData

class GetFilteredLocationsUseCase(private val locationsRepository: LocationsRepository) {
    fun getFilteredLocation(filterParameter: Pair<String, String>): LiveData<List<LocationObject>> {
        return locationsRepository.getFilteredLocations(filterParameter)
    }
}