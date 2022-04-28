package com.example.rickandmorty.domain.locations

class GetSingleLocationUseCase(private val locationsRepository: LocationsRepository) {
    fun getSingleLocation(){
        locationsRepository.getSingleLocation()
    }
}