package com.example.rickandmorty.domain.locations

class GetAllLocationsUseCase(private val locationsRepository: LocationsRepository) {
    fun getAllLocations() {
        locationsRepository.getAllLocations()
    }
}