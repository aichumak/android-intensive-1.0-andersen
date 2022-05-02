package com.example.rickandmorty.domain.episodes

class GetFilteredEpisodeUseCase(private val episodesRepository: EpisodesRepository) {
    fun getFilteredEpisode() {
        episodesRepository.getFilteredEpisodes()
    }
}