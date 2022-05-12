package com.example.rickandmorty.data.pojo

import com.example.rickandmorty.domain.episodes.EpisodeObject
import com.google.gson.annotations.Expose

data class EpisodeResult(
    @Expose
    val results: List<EpisodeObject>? = null,
    val info: EpisodeInfo? = null
)