package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.pojo.LocationInfo

@Dao
interface LocationInfoDao {
    @Query(
        "SELECT * FROM locations_list ORDER BY id" +
                "LIMIT :limit" +
                "OFFSET :offset"
    )
    fun getLocationsInfoList(limit: Int, offset: Int): List<LocationInfo>

    @Query("SELECT * FROM locations_list WHERE id== :locationId")
    fun getLocationInfo(locationId: Int): LocationInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationsInfo(locationsInfoList: List<LocationInfo>)
}