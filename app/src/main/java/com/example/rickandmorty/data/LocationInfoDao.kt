package com.example.rickandmorty.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.data.pojo.LocationInfo
import com.example.rickandmorty.data.pojo.LocationInfoModel

@Dao
interface LocationInfoDao {
    @Query(
        "SELECT * FROM locations_list ORDER BY id "
    )
    fun getLocationsInfoList(): LiveData<List<LocationInfoModel>>

    @Query("SELECT * FROM locations_list WHERE id=:locationId")
    suspend fun getLocationInfo(locationId: Int): LocationInfoModel

    @Query("SELECT * FROM locations_list WHERE url LIKE :url LIMIT 1")
    suspend fun getLocationInfoFromUrl(url: String): LocationInfoModel

    @Query("SELECT * FROM locations_list WHERE :fieldToSearch LIKE :valueForSearch")
    fun getFilteredLocationsInfoList(
        fieldToSearch: String,
        valueForSearch: String
    ): LiveData<List<LocationInfoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationsInfo(locationsInfoList: List<LocationInfoModel>)


}