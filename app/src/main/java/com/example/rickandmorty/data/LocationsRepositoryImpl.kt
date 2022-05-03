package com.example.rickandmorty.data

import android.content.Context
import com.example.rickandmorty.domain.locations.LocationsRepository
import com.example.rickandmorty.pojo.LocationInfo

class LocationsRepositoryImpl(context: Context): LocationsRepository {

    private val locationsDataBase = LocationsDataBase.getInstance(context)

    override fun getAllLocations(limit: Int, offset: Int): List<LocationInfo> {
        return locationsDataBase.locationInfoDao().getLocationsInfoList(limit, offset)
    }

    override fun getSingleLocation(id: Int): LocationInfo {
        return locationsDataBase.locationInfoDao().getLocationInfo(id)
    }

    override fun getFilteredLocations() {
        TODO("Not yet implemented")
    }
}