package com.example.rickandmorty.domain.locations

import com.example.rickandmorty.data.pojo.LocationInfoModel

interface LocationsRepository {
    fun addLocationList(locationList: List<LocationInfoModel>)
    suspend fun getAllLocations(): List<LocationObject>
    suspend fun getSingleLocation(id: Int): LocationObject
    suspend fun getFilteredLocations(filterParameter: Pair<String, String>): List<LocationObject>
}