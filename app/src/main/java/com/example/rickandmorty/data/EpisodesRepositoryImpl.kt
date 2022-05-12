package com.example.rickandmorty.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.rickandmorty.api.CharactersApiFactory
import com.example.rickandmorty.api.EpisodesApiFactory
import com.example.rickandmorty.domain.episodes.EpisodesRepository
import com.example.rickandmorty.data.pojo.EpisodeInfo
import com.example.rickandmorty.data.pojo.EpisodeInfoModel
import com.example.rickandmorty.domain.episodes.EpisodeObject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class EpisodesRepositoryImpl(context: Context, compositeDisposable: CompositeDisposable): EpisodesRepository {

    private val episodesInfoDao = EpisodesDataBase.getInstance(context).episodeInfoDao()
    private val mapper = EpisodesListMapper()

    init {
        for (i in 1..3) {
            val disposable = EpisodesApiFactory.apiService.getEpisodesInfoList(i)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    if (it != null) {
                        it.results?.let { results ->
                            addEpisodeList(mapper.mapListEntityToListDataBaseModel(results))
                            //Log.d("tst", "Load $i")
                        }

                    }
                }, {

                })

            compositeDisposable.add(disposable)
        }
    }

    override fun getAllEpisodes(): LiveData<List<EpisodeObject>> {
        return mapper.mapListDataBaseModelToListEntity(episodesInfoDao.getEpisodesInfoList())
    }

    override fun getSingleEpisode(id: Int): EpisodeObject {
        val episode = episodesInfoDao.getEpisodeInfo(id)
        return mapper.mapDataBaseModelToEntity(episode)
    }

    override fun addEpisodeList(episodeList: List<EpisodeInfoModel>) {
        episodesInfoDao.insertEpisodesInfo(episodeList)
    }

    override fun getFilteredEpisodes() {
        TODO("Not yet implemented")
    }
}