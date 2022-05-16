package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.locations.GetAllLocationsUseCase
import com.example.rickandmorty.domain.locations.LocationObject
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class LocationListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = LocationsRepositoryImpl
    private val getAllLocationsUseCase = GetAllLocationsUseCase(repository)
    //private val getSingleLocationUseCase = GetSingleLocationUseCase(repository)
    //private val getFilteredLocationUseCase = GetFilteredLocationUseCase(repository)

    var locationsList = getAllLocationsUseCase.getAllLocations()
    private val prevLocationsList = MutableLiveData<List<LocationObject>>()

    fun updateRequiredLocations() {
        locationsList = getAllLocationsUseCase.getAllLocations()
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        if (filterParameters == null) {
            //charactersList = getAllCharactersUseCase.getAllCharacters(arrayCharacters)
        } else {
            //getFilteredCharactersUseCase.getFilteredCharacters(filterParameters)
        }
    }

    fun replaceListForSearch(newList: TreeSet<LocationObject>) {
        prevLocationsList.value = locationsList.value
        locationsList = castToLiveDataList(newList)
    }

    private fun castToLiveDataList(newList: TreeSet<LocationObject>): LiveData<List<LocationObject>> {
        val liveData = MutableLiveData<List<LocationObject>>()
        liveData.value = newList.toList()
        return liveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}