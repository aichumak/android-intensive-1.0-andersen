package com.example.rickandmorty.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.character_details_name)
    val species: TextView = view.findViewById(R.id.character_details_species)
    val status: TextView = view.findViewById(R.id.character_details_status)
    val gender: TextView = view.findViewById(R.id.character_details_gender)
    val image: ImageView = view.findViewById(R.id.character_details_image)
}
