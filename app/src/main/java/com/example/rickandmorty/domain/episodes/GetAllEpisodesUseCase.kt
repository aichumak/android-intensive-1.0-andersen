package com.example.rickandmorty.domain.episodes

class GetAllEpisodesUseCase(private val episodesRepository: EpisodesRepository) {
    fun getAllEpisodes(limit: Int, offset: Int) {
        episodesRepository.getAllEpisodes(limit, offset)
    }
}