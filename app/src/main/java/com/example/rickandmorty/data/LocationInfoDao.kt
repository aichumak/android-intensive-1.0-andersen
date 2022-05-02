package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.pojo.LocationInfo
import com.example.rickandmorty.pojo.LocationsInfoListOfResult

@Dao
interface LocationInfoDao {
    @Query("SELECT * FROM locations_list ORDER BY id")
    fun getLocationsInfoList(): List<LocationsInfoListOfResult>

    @Query("SELECT * FROM locations_list WHERE id== :locationId")
    fun getLocationInfo(locationId: Int): LocationInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationsInfo(locationsInfoList: List<LocationsInfoListOfResult>)
}