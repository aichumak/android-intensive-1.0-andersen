package com.example.rickandmorty.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.domain.locations.LocationObject

class LocationDiffCallback : DiffUtil.ItemCallback<LocationObject>() {
    override fun areItemsTheSame(
        oldLocation: LocationObject,
        newLocation: LocationObject
    ): Boolean {
        return oldLocation.id == newLocation.id
    }

    override fun areContentsTheSame(
        oldLocation: LocationObject,
        newLocation: LocationObject
    ): Boolean {
        return oldLocation == newLocation
    }
}