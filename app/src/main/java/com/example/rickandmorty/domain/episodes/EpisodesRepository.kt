package com.example.rickandmorty.domain.episodes

import com.example.rickandmorty.data.pojo.EpisodeInfoModel

interface EpisodesRepository {
    fun addEpisodeList(episodeList: List<EpisodeInfoModel>)
    suspend fun getAllEpisodes(arrayList: ArrayList<String>?): List<EpisodeObject>
    suspend fun getSingleEpisode(id: Int): EpisodeObject
    suspend fun getFilteredEpisodes(filterParameter: Pair<String, String>): List<EpisodeObject>
}