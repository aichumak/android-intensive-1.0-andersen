package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.episodes.GetAllEpisodesUseCase
import io.reactivex.disposables.CompositeDisposable

class EpisodeListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    val repository = EpisodesRepositoryImpl
    private val getAllEpisodesUseCase = GetAllEpisodesUseCase(repository)
    //private val getSingleEpisodeUseCase = GetSingleEpisodeUseCase(repository)
    //private val getFilteredEpisodeUseCase = GetFilteredEpisodeUseCase(repository)

    val episodesList = getAllEpisodesUseCase.getAllEpisodes()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}