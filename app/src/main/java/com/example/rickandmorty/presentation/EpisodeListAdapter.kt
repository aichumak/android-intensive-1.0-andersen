package com.example.rickandmorty.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.CharactersRepository
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.EpisodesRepository
import com.example.rickandmorty.domain.episodes.GetAllEpisodesUseCase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class EpisodeListAdapter(
    val fragmentNavigator: FragmentNavigator? = null
) : androidx.recyclerview.widget.ListAdapter<EpisodeObject, EpisodeViewHolder>(
    EpisodeDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val episodeView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_episode_list_view, parent, false)
        return EpisodeViewHolder(episodeView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = getItem(position)
        with(holder) {
            name.text = ("Name: ${episode.name}")
            episodeView.text = ("Episode: ${episode.episode}")
            airDate.text = ("Air date: ${episode.air_date}")
            itemView.setOnClickListener {
                fragmentNavigator?.goToNextFragment(
                    FragmentsNames.EPISODE_DETAILS_FRAGMENT,
                    episode.id
                )
            }
        }
    }

}