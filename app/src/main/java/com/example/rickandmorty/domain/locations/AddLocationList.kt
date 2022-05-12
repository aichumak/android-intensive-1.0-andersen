package com.example.rickandmorty.domain.locations

import com.example.rickandmorty.data.pojo.LocationInfoModel

class AddLocationList(private val locationsRepository: LocationsRepository) {
    fun addLocationList(locationList: List<LocationInfoModel>) {
        return locationsRepository.addLocationList(locationList)
    }
}