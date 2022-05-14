package com.example.rickandmorty.domain.episodes

data class EpisodeObject(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: ArrayList<String>,
    val url: String,
    val created: String
)