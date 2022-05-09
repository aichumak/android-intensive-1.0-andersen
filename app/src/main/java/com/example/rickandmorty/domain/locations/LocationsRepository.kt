package com.example.rickandmorty.domain.locations

import com.example.rickandmorty.data.pojo.LocationInfoModel

interface LocationsRepository {
    fun getAllLocations(limit: Int, offset: Int): List<LocationInfoModel>
    fun getSingleLocation(id: Int): LocationInfoModel
    fun getFilteredLocations()
}