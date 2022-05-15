package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.GetAllEpisodesUseCase
import io.reactivex.disposables.CompositeDisposable

class EpisodeListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = EpisodesRepositoryImpl
    private val getAllEpisodesUseCase = GetAllEpisodesUseCase(repository)
    private var arrayEpisodes: ArrayList<String>? = null

    //var episodesList = getAllEpisodesUseCase.getAllEpisodes(arrayEpisodes)
    var episodesList: LiveData<List<EpisodeObject>>? = null

    fun updateArrayEpisodes(arrayList: ArrayList<String>?) {
        arrayEpisodes = arrayList
        episodesList = getAllEpisodesUseCase.getAllEpisodes(arrayEpisodes)
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        if (filterParameters == null) {
            //charactersList = getAllCharactersUseCase.getAllCharacters(arrayCharacters)
        } else {
            //getFilteredCharactersUseCase.getFilteredCharacters(filterParameters)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}