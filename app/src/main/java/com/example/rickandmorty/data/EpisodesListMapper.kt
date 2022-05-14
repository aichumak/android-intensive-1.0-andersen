package com.example.rickandmorty.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.rickandmorty.data.pojo.EpisodeInfoModel
import com.example.rickandmorty.domain.episodes.EpisodeObject

class EpisodesListMapper {

    private fun mapEntityToDataBaseModel(episodeObject: EpisodeObject) = EpisodeInfoModel(
        id = episodeObject.id,
        name = episodeObject.name,
        air_date = episodeObject.air_date,
        episode = episodeObject.episode,
        characters = episodeObject.characters.toString().replace("[", "").replace("]", ""),
        url = episodeObject.url,
        created = episodeObject.created
    )

    fun mapDataBaseModelToEntity(episodeInfoModel: EpisodeInfoModel) = EpisodeObject(
        id = episodeInfoModel.id,
        name = episodeInfoModel.name,
        air_date = episodeInfoModel.air_date,
        episode = episodeInfoModel.episode,
        characters = ArrayList(episodeInfoModel.characters.trim().split(",")),
        url = episodeInfoModel.url,
        created = episodeInfoModel.created
    )

    fun mapListDataBaseModelToListEntity(liveDataList: LiveData<List<EpisodeInfoModel>>) =
        liveDataList.map {
            it.map { episode -> mapDataBaseModelToEntity(episode) }
        }

    fun mapListEntityToListDataBaseModel(entityList: List<EpisodeObject>) =
        entityList.map { episode -> mapEntityToDataBaseModel(episode) }

}

