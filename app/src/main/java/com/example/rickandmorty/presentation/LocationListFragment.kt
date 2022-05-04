package com.example.rickandmorty.presentation

import androidx.fragment.app.Fragment
import com.example.rickandmorty.R

class LocationListFragment: Fragment(R.layout.fragment_location_list) {

    companion object {
        val FRAGMENT_LOCATION_LIST = "FRAGMENT_LOCATION_LIST"
        fun newInstance() = LocationListFragment()
    }
}