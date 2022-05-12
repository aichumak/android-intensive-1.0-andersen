package com.example.rickandmorty.domain.episodes

import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.pojo.EpisodeInfoModel

interface EpisodesRepository {
    fun addEpisodeList(episodeList: List<EpisodeInfoModel>)
    fun getAllEpisodes(): LiveData<List<EpisodeObject>>
    fun getSingleEpisode(id: Int): EpisodeObject
    fun getFilteredEpisodes()
}