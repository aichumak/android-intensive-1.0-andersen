package com.example.rickandmorty.domain.locations

import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.pojo.LocationInfoModel
import com.example.rickandmorty.domain.episodes.EpisodeObject

interface LocationsRepository {
    fun addLocationList(locationList: List<LocationInfoModel>)
    fun getAllLocations(): LiveData<List<LocationObject>>
    suspend fun getSingleLocation(id: Int): LocationObject
    fun getFilteredLocations(filterParameter: Pair<String, String>): LiveData<List<LocationObject>>
}