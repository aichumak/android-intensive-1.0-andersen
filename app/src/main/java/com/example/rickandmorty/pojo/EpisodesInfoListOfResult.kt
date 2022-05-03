package com.example.rickandmorty.pojo

import com.google.gson.JsonArray
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EpisodesInfoListOfResult(
//    @SerializedName("results")
//    @Expose
    val results: List<EpisodeInfo>
)