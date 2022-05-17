package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetFilteredCharactersUseCase
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.GetAllEpisodesUseCase
import com.example.rickandmorty.domain.episodes.GetFilteredEpisodesUseCase
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import kotlin.collections.ArrayList

class EpisodeListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = EpisodesRepositoryImpl
    private val getAllEpisodesUseCase = GetAllEpisodesUseCase(repository)
    private val getFilteredEpisodes = GetFilteredEpisodesUseCase(repository)

    var episodesList: LiveData<List<EpisodeObject>>? = null

    fun updateArrayEpisodes(arrayList: ArrayList<String>?) {
        episodesList = getAllEpisodesUseCase.getAllEpisodes(arrayList)
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        episodesList = if (filterParameters == null) {
            getAllEpisodesUseCase.getAllEpisodes(null)
        } else {
            getFilteredEpisodes.getFilteredEpisodes(filterParameters)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}