package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.pojo.LocationInfo
import com.example.rickandmorty.data.pojo.LocationInfoModel

@Dao
interface LocationInfoDao {
    @Query(
        "SELECT * FROM locations_list ORDER BY id " +
                "LIMIT :limit " +
                "OFFSET :offset"
    )
    fun getLocationsInfoList(limit: Int, offset: Int): List<LocationInfoModel>

    @Query("SELECT * FROM locations_list WHERE id== :locationId")
    fun getLocationInfo(locationId: Int): LocationInfoModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationsInfo(locationsInfoList: List<LocationInfoModel>)
}