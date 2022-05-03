package com.example.rickandmorty.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.locations.GetAllLocationsUseCase
import com.example.rickandmorty.domain.locations.GetFilteredLocationUseCase
import com.example.rickandmorty.domain.locations.GetSingleLocationUseCase

class LocationListViewModel(context: Context) : ViewModel() {
    private val repository = LocationsRepositoryImpl(context)
    private val getAllLocationsUseCase = GetAllLocationsUseCase(repository)
    private val getSingleLocationUseCase = GetSingleLocationUseCase(repository)
    private val getFilteredLocationUseCase = GetFilteredLocationUseCase(repository)

}