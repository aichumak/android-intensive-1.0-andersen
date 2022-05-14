package com.example.rickandmorty.domain.episodes

class GetSingleEpisodeUseCase(private val episodesRepository: EpisodesRepository) {
    suspend fun getSingleEpisode(id: Int): EpisodeObject {
        return episodesRepository.getSingleEpisode(id)
    }
}