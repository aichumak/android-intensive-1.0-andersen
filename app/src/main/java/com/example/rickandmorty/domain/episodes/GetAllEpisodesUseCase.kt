package com.example.rickandmorty.domain.episodes

import androidx.lifecycle.LiveData

class GetAllEpisodesUseCase(private val episodesRepository: EpisodesRepository) {
    fun getAllEpisodes(arrayList: ArrayList<String>?): LiveData<List<EpisodeObject>> {
        return episodesRepository.getAllEpisodes(arrayList)
    }
}