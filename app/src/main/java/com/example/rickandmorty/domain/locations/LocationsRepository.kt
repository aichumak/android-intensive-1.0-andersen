package com.example.rickandmorty.domain.locations

interface LocationsRepository {
    fun getAllLocations()
    fun getSingleLocation()
    fun getFilteredLocations()
}