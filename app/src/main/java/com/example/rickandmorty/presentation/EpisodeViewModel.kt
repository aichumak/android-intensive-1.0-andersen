package com.example.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.example.rickandmorty.domain.episodes.GetSingleEpisodeUseCase
import io.reactivex.disposables.CompositeDisposable

class EpisodeViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repository = EpisodesRepositoryImpl
    private val getSingleEpisodeUseCase = GetSingleEpisodeUseCase(repository)

    fun getSingleEpisode(id: Int): EpisodeObject {
        return getSingleEpisodeUseCase.getSingleEpisode(id)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}