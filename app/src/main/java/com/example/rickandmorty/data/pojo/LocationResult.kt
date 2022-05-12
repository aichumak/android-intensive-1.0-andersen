package com.example.rickandmorty.data.pojo

import com.example.rickandmorty.domain.locations.LocationObject
import com.google.gson.annotations.Expose

data class LocationResult(
    @Expose
    val results: List<LocationObject>? = null,
    val info: LocationInfo? = null
)