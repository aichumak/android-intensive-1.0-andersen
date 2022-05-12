package com.example.rickandmorty.domain.episodes

import androidx.lifecycle.LiveData

class GetAllEpisodesUseCase(private val episodesRepository: EpisodesRepository) {
    fun getAllEpisodes(): LiveData<List<EpisodeObject>> {
        return episodesRepository.getAllEpisodes()
    }
}