package com.example.rickandmorty.domain.episodes

interface EpisodesRepository {
    fun getAllEpisodes()
    fun getSingleEpisode()
    fun getFilteredEpisodes()
}