package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.pojo.LocationInfoModel

@Dao
interface LocationInfoDao {
    @Query("SELECT * FROM locations_list ORDER BY id")
    suspend fun getLocationsInfoList(): List<LocationInfoModel>

    @Query("SELECT * FROM locations_list WHERE id=:locationId")
    suspend fun getLocationInfo(locationId: Int): LocationInfoModel

    @Query("SELECT * FROM locations_list WHERE url LIKE :url LIMIT 1")
    suspend fun getLocationInfoFromUrl(url: String): LocationInfoModel

    @Query("SELECT * FROM locations_list WHERE name LIKE :valueForSearch ORDER BY id")
    suspend fun getNameFilteredLocationsInfoList(valueForSearch: String): List<LocationInfoModel>

    @Query("SELECT * FROM locations_list WHERE type LIKE :valueForSearch ORDER BY id")
    suspend fun getTypeFilteredLocationsInfoList(valueForSearch: String): List<LocationInfoModel>

    @Query("SELECT * FROM locations_list WHERE dimension LIKE :valueForSearch ORDER BY id")
    suspend fun getDimensionFilteredLocationsInfoList(valueForSearch: String): List<LocationInfoModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationsInfo(locationsInfoList: List<LocationInfoModel>)

}