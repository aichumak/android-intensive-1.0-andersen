package com.example.rickandmorty.domain.locations

class GetFilteredLocationsUseCase(private val locationsRepository: LocationsRepository) {
    suspend fun getFilteredLocation(filterParameter: Pair<String, String>): List<LocationObject> {
        return locationsRepository.getFilteredLocations(filterParameter)
    }
}