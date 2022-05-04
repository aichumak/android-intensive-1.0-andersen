package com.example.rickandmorty.domain.locations

class GetAllLocationsUseCase(private val locationsRepository: LocationsRepository) {
    fun getAllLocations(limit: Int, offset: Int) {
        locationsRepository.getAllLocations(limit, offset)
    }
}