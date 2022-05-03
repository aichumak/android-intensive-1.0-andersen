package com.example.rickandmorty.domain.locations

import com.example.rickandmorty.pojo.CharacterInfo
import com.example.rickandmorty.pojo.LocationInfo

interface LocationsRepository {
    fun getAllLocations(limit: Int, offset: Int): List<LocationInfo>
    fun getSingleLocation(id: Int): LocationInfo
    fun getFilteredLocations()
}