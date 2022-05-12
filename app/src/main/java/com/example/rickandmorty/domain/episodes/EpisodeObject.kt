package com.example.rickandmorty.domain.episodes

class EpisodeObject(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: Array<String>,
    val url: String,
    val created: String
)