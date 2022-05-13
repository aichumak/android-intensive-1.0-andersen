package com.example.rickandmorty.domain.episodes

class GetSingleEpisodeUseCase(private val episodesRepository: EpisodesRepository) {
    fun getSingleEpisode(id: Int): EpisodeObject {
        return episodesRepository.getSingleEpisode(id)
    }
}