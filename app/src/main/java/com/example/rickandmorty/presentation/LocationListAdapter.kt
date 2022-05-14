package com.example.rickandmorty.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.CharactersRepository
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.example.rickandmorty.domain.locations.GetAllLocationsUseCase
import com.example.rickandmorty.domain.locations.LocationObject
import com.example.rickandmorty.domain.locations.LocationsRepository
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class LocationListAdapter(
    val fragmentNavigator: FragmentNavigator? = null
) : androidx.recyclerview.widget.ListAdapter<LocationObject, LocationViewHolder>(
    LocationDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val locationView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_location_list_view, parent, false)
        return LocationViewHolder(locationView)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = getItem(position)
        with(holder) {
            name.text = location.name
            type.text = location.type
            dimension.text = location.dimension
            itemView.setOnClickListener {
                fragmentNavigator?.goToNextFragment(
                    FragmentsNames.LOCATION_DETAILS_FRAGMENT,
                    position
                )
            }
        }
    }

}