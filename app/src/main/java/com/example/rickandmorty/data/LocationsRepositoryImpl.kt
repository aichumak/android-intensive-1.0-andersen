package com.example.rickandmorty.data

import android.util.Log
import androidx.lifecycle.LiveData
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

    override fun getAllLocations(): LiveData<List<LocationObject>> {
        return mapper.mapListDataBaseModelToListEntity(locationsInfoDao.getLocationsInfoList())
    }

    override fun getSingleLocation(id: Int): LocationObject {
        val location = locationsInfoDao.getLocationInfo(id)
        return mapper.mapDataBaseModelToEntity(location)
    }

    override fun addLocationList(locationList: List<LocationInfoModel>) {
        locationsInfoDao.insertLocationsInfo(locationList)
    }

    override fun getFilteredLocations() {
        TODO("Not yet implemented")
    }
}