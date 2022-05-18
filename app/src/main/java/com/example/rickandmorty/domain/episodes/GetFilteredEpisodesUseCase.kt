package com.example.rickandmorty.domain.episodes

class GetFilteredEpisodesUseCase(private val episodesRepository: EpisodesRepository) {
    suspend fun getFilteredEpisodes(filterParameter: Pair<String, String>): List<EpisodeObject> {
        return episodesRepository.getFilteredEpisodes(filterParameter)
    }
}