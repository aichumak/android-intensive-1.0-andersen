package com.example.rickandmorty.domain.episodes

class GetAllEpisodesUseCase(private val episodesRepository: EpisodesRepository) {
    suspend fun getAllEpisodes(arrayList: ArrayList<String>?): List<EpisodeObject> {
        return episodesRepository.getAllEpisodes(arrayList)
    }
}