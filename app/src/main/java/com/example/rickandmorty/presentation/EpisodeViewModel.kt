package com.example.rickandmorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.GetSingleEpisodeUseCase
import kotlinx.coroutines.launch

class EpisodeViewModel : ViewModel() {
    private val repository = EpisodesRepositoryImpl
    private val getSingleEpisodeUseCase = GetSingleEpisodeUseCase(repository)

    val episode = MutableLiveData<EpisodeObject>()

    fun getSingleEpisode(itemId: Int) {
        viewModelScope.launch {
            val item = getSingleEpisodeUseCase.getSingleEpisode(itemId)
            episode.value = item
        }
    }
}