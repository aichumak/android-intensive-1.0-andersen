package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.GetAllEpisodesUseCase
import com.example.rickandmorty.domain.episodes.GetFilteredEpisodesUseCase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import java.util.*

class EpisodeListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = EpisodesRepositoryImpl
    private val getAllEpisodesUseCase = GetAllEpisodesUseCase(repository)
    private val getFilteredEpisodes = GetFilteredEpisodesUseCase(repository)

    val episodesList = MutableLiveData<List<EpisodeObject>>()
    private val episodesListFromDb = MutableLiveData<List<EpisodeObject>>()

    fun restoreEpisodesList() {
        episodesList.value = episodesListFromDb.value
    }

    fun updateRequiredEpisodes(arrayList: ArrayList<String>?) {
        viewModelScope.launch {
            episodesListFromDb.value = getAllEpisodesUseCase.getAllEpisodes(arrayList)
            restoreEpisodesList()
        }
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        viewModelScope.launch {
            episodesListFromDb.value = if (filterParameters == null) {
                getAllEpisodesUseCase.getAllEpisodes(null)
            } else {
                getFilteredEpisodes.getFilteredEpisodes(filterParameters)
            }
            restoreEpisodesList()
        }
    }

    fun replaceListForSearch(newList: TreeSet<EpisodeObject>) {
        episodesList.value = newList.toList()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}