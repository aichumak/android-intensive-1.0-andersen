package com.example.rickandmorty.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rickandmorty.R
import com.example.rickandmorty.domain.locations.LocationObject

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

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = getItem(position)
        with(holder) {
            name.text = ("Name: ${location.name}")
            type.text = ("Type: ${location.type}")
            dimension.text = ("Dimension: ${location.dimension}")
            itemView.setOnClickListener {
                fragmentNavigator?.goToNextFragment(
                    FragmentsNames.LOCATION_DETAILS_FRAGMENT,
                    location.id
                )
            }
        }
    }

}