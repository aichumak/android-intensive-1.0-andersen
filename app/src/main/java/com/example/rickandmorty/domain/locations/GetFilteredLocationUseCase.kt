package com.example.rickandmorty.domain.locations

class GetFilteredLocationUseCase(private val locationsRepository: LocationsRepository) {
    fun getFilteredLocation() {
        locationsRepository.getFilteredLocations()
    }
}