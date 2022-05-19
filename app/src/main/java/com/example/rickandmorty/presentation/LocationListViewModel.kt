package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.locations.GetAllLocationsUseCase
import com.example.rickandmorty.domain.locations.GetFilteredLocationsUseCase
import com.example.rickandmorty.domain.locations.LocationObject
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import java.util.*

class LocationListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = LocationsRepositoryImpl
    private val getAllLocations = GetAllLocationsUseCase(repository)
    private val getFilteredLocations = GetFilteredLocationsUseCase(repository)

    val locationsList = MutableLiveData<List<LocationObject>>()
    private val locationsListFromDb = MutableLiveData<List<LocationObject>>()

    fun restoreLocationsList() {
        locationsList.value = locationsListFromDb.value
    }

    fun updateRequiredLocations() {
        viewModelScope.launch {
            locationsListFromDb.value = getAllLocations.getAllLocations()
            restoreLocationsList()
        }
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        viewModelScope.launch {
            locationsListFromDb.value = if (filterParameters == null) {
                getAllLocations.getAllLocations()
            } else {
                getFilteredLocations.getFilteredLocation(filterParameters)
            }
            restoreLocationsList()
        }
    }

    fun replaceListForSearch(newList: TreeSet<LocationObject>) {
        locationsList.value = newList.toList()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}