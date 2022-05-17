package com.example.rickandmorty.domain.locations

class GetAllLocationsUseCase(private val locationsRepository: LocationsRepository) {
    suspend fun getAllLocations(): List<LocationObject> {
        return locationsRepository.getAllLocations()
    }
}