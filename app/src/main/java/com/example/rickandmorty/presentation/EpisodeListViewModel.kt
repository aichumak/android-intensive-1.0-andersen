package com.example.rickandmorty.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.EpisodesRepositoryImpl
import com.example.rickandmorty.domain.episodes.GetAllEpisodesUseCase
import com.example.rickandmorty.domain.episodes.GetFilteredEpisodeUseCase
import com.example.rickandmorty.domain.episodes.GetSingleEpisodeUseCase

class EpisodeListViewModel(context: Context) : ViewModel() {
    private val repository = EpisodesRepositoryImpl(context)
    private val getAllEpisodesUseCase = GetAllEpisodesUseCase(repository)
    private val getSingleEpisodeUseCase = GetSingleEpisodeUseCase(repository)
    private val getFilteredEpisodeUseCase = GetFilteredEpisodeUseCase(repository)


}