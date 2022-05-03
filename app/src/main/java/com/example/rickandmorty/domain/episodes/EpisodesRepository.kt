package com.example.rickandmorty.domain.episodes

import com.example.rickandmorty.pojo.EpisodeInfo

interface EpisodesRepository {
    fun getAllEpisodes(limit: Int, offset: Int): List<EpisodeInfo>
    fun getSingleEpisode(id: Int): EpisodeInfo
    fun getFilteredEpisodes()
}