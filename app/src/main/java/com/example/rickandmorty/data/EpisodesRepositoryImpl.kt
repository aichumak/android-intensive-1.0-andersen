package com.example.rickandmorty.data

import com.example.rickandmorty.api.EpisodesApiFactory
import com.example.rickandmorty.data.pojo.EpisodeInfoModel
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.EpisodesRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

object EpisodesRepositoryImpl : EpisodesRepository {
    private val compositeDisposable = CompositeDisposable()
    private val episodesInfoDao = EpisodesDataBase.getInstance().episodeInfoDao()
    private val mapper = EpisodesListMapper()

    init {
        for (i in 1..3) {
            val disposable = EpisodesApiFactory.apiService.getEpisodesInfoList(i)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    if (it != null) {
                        it.results?.let { results ->
                            addEpisodeList(mapper.mapListEntityToListDataBaseModel(results))
                        }

                    }
                }, {

                })

            compositeDisposable.add(disposable)
        }
    }

    override suspend fun getAllEpisodes(arrayList: ArrayList<String>?): List<EpisodeObject> {
        return mapper.mapListDataBaseModelToListEntity(
            if (arrayList == null) {
                episodesInfoDao.getAllEpisodesInfoList()
            } else {
                episodesInfoDao.getRequiredEpisodesInfoList(arrayList)
            }
        )
    }

    override suspend fun getSingleEpisode(id: Int): EpisodeObject {
        val episode = episodesInfoDao.getEpisodeInfo(id)
        return mapper.mapDataBaseModelToEntity(episode)
    }

    override fun addEpisodeList(episodeList: List<EpisodeInfoModel>) {
        episodesInfoDao.insertEpisodesInfo(episodeList)
    }

    override suspend fun getFilteredEpisodes(filterParameters: Pair<String, String>): List<EpisodeObject> {
        return mapper.mapListDataBaseModelToListEntity(
            when (filterParameters.first) {
                "name" -> episodesInfoDao.getNameFilteredEpisodesInfoList(filterParameters.second)
                "episode" -> episodesInfoDao.getEpisodeFilteredEpisodesInfoList(filterParameters.second)
                else -> throw Exception()
            }
        )
    }
}