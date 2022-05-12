package com.example.rickandmorty.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R

class LocationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.location_details_name)
    val type: TextView = view.findViewById(R.id.location_details_type)
    val dimension: TextView = view.findViewById(R.id.location_details_dimension)
}
