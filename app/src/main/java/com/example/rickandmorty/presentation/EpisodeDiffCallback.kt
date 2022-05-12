package com.example.rickandmorty.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.domain.episodes.EpisodeObject

class EpisodeDiffCallback : DiffUtil.ItemCallback<EpisodeObject>() {
    override fun areItemsTheSame(
        oldEpisode: EpisodeObject,
        newEpisode: EpisodeObject
    ): Boolean {
        return oldEpisode.id == newEpisode.id
    }

    override fun areContentsTheSame(
        oldEpisode: EpisodeObject,
        newEpisode: EpisodeObject
    ): Boolean {
        return oldEpisode == newEpisode
    }
}