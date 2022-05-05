package com.example.rickandmorty.domain.episodes

import com.example.rickandmorty.data.pojo.EpisodeInfo
import com.example.rickandmorty.data.pojo.EpisodeInfoModel

interface EpisodesRepository {
    fun getAllEpisodes(limit: Int, offset: Int): List<EpisodeInfoModel>
    fun getSingleEpisode(id: Int): EpisodeInfoModel
    fun getFilteredEpisodes()
}