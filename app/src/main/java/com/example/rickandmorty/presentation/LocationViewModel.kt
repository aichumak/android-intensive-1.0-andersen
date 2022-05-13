package com.example.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.locations.GetSingleLocationUseCase
import com.example.rickandmorty.domain.locations.LocationObject
import io.reactivex.disposables.CompositeDisposable

class LocationViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repository = LocationsRepositoryImpl
    private val getSingleLocationUseCase = GetSingleLocationUseCase(repository)

    fun getSingleLocation(id: Int): LocationObject {
        return getSingleLocationUseCase.getSingleLocation(id)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}