package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.GetAllEpisodesUseCase
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import kotlin.collections.ArrayList

class EpisodeListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = EpisodesRepositoryImpl
    private val getAllEpisodesUseCase = GetAllEpisodesUseCase(repository)
    private var arrayEpisodes: ArrayList<String>? = null

    val episodesList = MutableLiveData<List<EpisodeObject>>()
    private val prevEpisodesList = MutableLiveData<List<EpisodeObject>>()

    fun updateArrayEpisodes(arrayList: ArrayList<String>?) {
        arrayEpisodes = arrayList
        episodesList.value = getAllEpisodesUseCase.getAllEpisodes(arrayEpisodes).value
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        if (filterParameters == null) {
            //charactersList = getAllCharactersUseCase.getAllCharacters(arrayCharacters)
        } else {
            //getFilteredCharactersUseCase.getFilteredCharacters(filterParameters)
        }
    }

    fun replaceListForSearch(newList: TreeSet<EpisodeObject>) {
        prevEpisodesList.value = episodesList.value
        episodesList.value = newList.toList()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}