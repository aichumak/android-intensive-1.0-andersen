package com.example.rickandmorty.data

import android.util.Log
import com.example.rickandmorty.api.LocationsApiFactory
import com.example.rickandmorty.data.pojo.LocationInfoModel
import com.example.rickandmorty.domain.locations.LocationObject
import com.example.rickandmorty.domain.locations.LocationsRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

object LocationsRepositoryImpl : LocationsRepository {
    private val compositeDisposable = CompositeDisposable()
    private val locationsInfoDao = LocationsDataBase.getInstance().locationInfoDao()
    private val mapper = LocationsListMapper()

    init {
        for (i in 1..7) {
            val disposable = LocationsApiFactory.apiService.getLocationsInfoList(i)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    if (it != null) {
                        it.results?.let { results ->
                            addLocationList(mapper.mapListEntityToListDataBaseModel(results))
                            Log.d("tst", "Load $i")
                        }
                    }
                }, {

                })

            compositeDisposable.add(disposable)
        }
    }

    override suspend fun getAllLocations(): List<LocationObject> {
        return mapper.mapListDataBaseModelToListEntity(locationsInfoDao.getLocationsInfoList())
    }

    override suspend fun getSingleLocation(id: Int): LocationObject {
        val location = locationsInfoDao.getLocationInfo(id)
        return mapper.mapDataBaseModelToEntity(location)
    }

    override fun addLocationList(locationList: List<LocationInfoModel>) {
        locationsInfoDao.insertLocationsInfo(locationList)
    }

    override suspend fun getFilteredLocations(filterParameters: Pair<String, String>): List<LocationObject> {
        return mapper.mapListDataBaseModelToListEntity(
            when (filterParameters.first) {
                "name" -> locationsInfoDao.getNameFilteredLocationsInfoList(filterParameters.second)
                "type" -> locationsInfoDao.getTypeFilteredLocationsInfoList(filterParameters.second)
                "dimension" -> locationsInfoDao.getDimensionFilteredLocationsInfoList(
                    filterParameters.second
                )
                else -> throw Exception()
            }
        )
    }
}