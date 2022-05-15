package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.locations.GetAllLocationsUseCase
import com.example.rickandmorty.domain.locations.LocationObject
import io.reactivex.disposables.CompositeDisposable

class LocationListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    val repository = LocationsRepositoryImpl
    private val getAllLocationsUseCase = GetAllLocationsUseCase(repository)
    //private val getSingleLocationUseCase = GetSingleLocationUseCase(repository)
    //private val getFilteredLocationUseCase = GetFilteredLocationUseCase(repository)

    val locationsList = getAllLocationsUseCase.getAllLocations()


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}