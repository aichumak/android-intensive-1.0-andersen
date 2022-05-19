package com.example.rickandmorty.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R

class EpisodeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.episode_details_name)
    val episodeView: TextView = view.findViewById(R.id.episode_details_episode)
    val airDate: TextView = view.findViewById(R.id.episode_details_air_date)
}
