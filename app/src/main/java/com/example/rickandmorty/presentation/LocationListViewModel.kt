package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.locations.GetAllLocationsUseCase
import com.example.rickandmorty.domain.locations.GetFilteredLocationsUseCase
import io.reactivex.disposables.CompositeDisposable

class LocationListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = LocationsRepositoryImpl
    private val getAllLocations = GetAllLocationsUseCase(repository)
    private val getFilteredLocations = GetFilteredLocationsUseCase(repository)

    var locationsList = getAllLocations.getAllLocations()

    fun updateRequiredLocations() {
        locationsList = getAllLocations.getAllLocations()
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        locationsList = if (filterParameters == null) {
            getAllLocations.getAllLocations()
        } else {
            getFilteredLocations.getFilteredLocation(filterParameters)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}