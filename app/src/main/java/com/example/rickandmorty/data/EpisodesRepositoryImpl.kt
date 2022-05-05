package com.example.rickandmorty.data

import android.content.Context
import com.example.rickandmorty.domain.episodes.EpisodesRepository
import com.example.rickandmorty.data.pojo.EpisodeInfo
import com.example.rickandmorty.data.pojo.EpisodeInfoModel

class EpisodesRepositoryImpl(context: Context): EpisodesRepository {

    private val episodesDataBase = EpisodesDataBase.getInstance(context)

    override fun getAllEpisodes(limit: Int, offset: Int): List<EpisodeInfoModel> {
       return episodesDataBase.episodeInfoDao().getEpisodesInfoList(limit, offset)
    }

    override fun getSingleEpisode(id: Int): EpisodeInfoModel {
        return episodesDataBase.episodeInfoDao().getEpisodeInfo(id)
    }

    override fun getFilteredEpisodes() {
        TODO("Not yet implemented")
    }
}