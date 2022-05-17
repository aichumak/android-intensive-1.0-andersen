package com.example.rickandmorty.domain.episodes

import androidx.lifecycle.LiveData

class GetFilteredEpisodesUseCase(private val episodesRepository: EpisodesRepository) {
    fun getFilteredEpisodes (filterParameter: Pair<String, String>): LiveData<List<EpisodeObject>> {
        return episodesRepository.getFilteredEpisodes(filterParameter)
    }
}