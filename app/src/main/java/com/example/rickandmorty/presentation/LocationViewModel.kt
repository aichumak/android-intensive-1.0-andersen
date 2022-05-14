package com.example.rickandmorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.locations.GetSingleLocationUseCase
import com.example.rickandmorty.domain.locations.LocationObject
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repository = LocationsRepositoryImpl
    private val getSingleLocationUseCase = GetSingleLocationUseCase(repository)

    val location = MutableLiveData<LocationObject>()

    fun getSingleLocation(position: Int) {
        viewModelScope.launch {
            val item = getSingleLocationUseCase.getSingleLocation(position+1)
            location.value = item
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}