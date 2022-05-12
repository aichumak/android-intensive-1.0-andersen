package com.example.rickandmorty.presentation

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
    repository: EpisodesRepository
    //private val fragmentNavigator: FragmentNavigator
    //private val clickListener: ClickListener? = null
) : androidx.recyclerview.widget.ListAdapter<EpisodeObject, EpisodeViewHolder>(
    EpisodeDiffCallback()
) {
    //private val repository = CharactersRepositoryImpl(context, compositeDisposable)
    private val getAllEpisodesUseCase = GetAllEpisodesUseCase(repository)
    //private val getCharacterUseCase = GetCharacterUseCase(repository)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val episodeView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_episode_list_view, parent, false)
        return EpisodeViewHolder(episodeView)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = getItem(position)
        with(holder) {
            name.text = episode.name
            episodeView.text = episode.episode
            airDate.text = episode.air_date
            itemView.setOnClickListener {
//                fragmentNavigator?.goFromContactListFragmentToContactFragment(contact.id)
//                viewModel?.savedSearchText = ""
            }
            itemView.setOnLongClickListener {
//                clickListener?.removeContact(contact.id)
                true
            }
        }
    }

}