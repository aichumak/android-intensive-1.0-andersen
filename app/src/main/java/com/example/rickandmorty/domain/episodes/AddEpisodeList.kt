package com.example.rickandmorty.domain.episodes

import com.example.rickandmorty.data.pojo.EpisodeInfoModel

class AddEpisodeList(private val episodesRepository: EpisodesRepository) {
    fun addEpisodeList(episodeList: List<EpisodeInfoModel>) {
        return episodesRepository.addEpisodeList(episodeList)
    }
}