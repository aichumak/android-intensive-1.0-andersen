package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.GetAllEpisodesUseCase
import io.reactivex.disposables.CompositeDisposable

class EpisodeListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    val repository = EpisodesRepositoryImpl
    private val getAllEpisodesUseCase = GetAllEpisodesUseCase(repository)
    private var arrayEpisodes: ArrayList<String>? = null

    val episodesList = getAllEpisodesUseCase.getAllEpisodes(arrayEpisodes)

    fun updateArrayEpisodes(arrayList: ArrayList<String>?) {
        arrayEpisodes = arrayList
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}