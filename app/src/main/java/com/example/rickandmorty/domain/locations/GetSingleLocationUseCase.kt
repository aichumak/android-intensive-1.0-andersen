package com.example.rickandmorty.domain.locations

class GetSingleLocationUseCase(private val locationsRepository: LocationsRepository) {
    fun getSingleLocation(id: Int): LocationObject {
        return locationsRepository.getSingleLocation(id)
    }
}