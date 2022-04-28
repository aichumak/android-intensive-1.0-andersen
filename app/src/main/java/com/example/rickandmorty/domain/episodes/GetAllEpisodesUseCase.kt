package com.example.rickandmorty.domain.episodes

class GetAllEpisodesUseCase(private val episodesRepository: EpisodesRepository) {
    fun getAllEpisodes(){
        episodesRepository.getAllEpisodes()
    }
}