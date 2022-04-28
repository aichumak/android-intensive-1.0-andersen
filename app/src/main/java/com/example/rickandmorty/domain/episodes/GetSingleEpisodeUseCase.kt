package com.example.rickandmorty.domain.episodes

class GetSingleEpisodeUseCase(private val episodesRepository: EpisodesRepository) {
    fun getSingleEpisode(){
        episodesRepository.getSingleEpisode()
    }
}