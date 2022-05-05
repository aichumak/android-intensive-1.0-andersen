package com.example.rickandmorty.data

import android.content.Context
import com.example.rickandmorty.domain.locations.LocationsRepository
import com.example.rickandmorty.data.pojo.LocationInfo
import com.example.rickandmorty.data.pojo.LocationInfoModel

class LocationsRepositoryImpl(context: Context): LocationsRepository {

    private val locationsDataBase = LocationsDataBase.getInstance(context)

    override fun getAllLocations(limit: Int, offset: Int): List<LocationInfoModel> {
        return locationsDataBase.locationInfoDao().getLocationsInfoList(limit, offset)
    }

    override fun getSingleLocation(id: Int): LocationInfoModel {
        return locationsDataBase.locationInfoDao().getLocationInfo(id)
    }

    override fun getFilteredLocations() {
        TODO("Not yet implemented")
    }
}