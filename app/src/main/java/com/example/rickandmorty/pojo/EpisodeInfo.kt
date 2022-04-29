package com.example.rickandmorty.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class EpisodeInfo(

    @SerializedName("id")
    @Expose
    private val id: Int? = null,

    @SerializedName("name")
    @Expose
    private val name: String? = null,

    @SerializedName("air_date")
    @Expose
    private val airDate: String? = null,

    @SerializedName("episode")
    @Expose
    private val episode: String? = null,

    @SerializedName("characters")
    @Expose
    private val characters: List<String>? = null,

    @SerializedName("url")
    @Expose
    private val url: String? = null,

    @SerializedName("created")
    @Expose
    private val created: String? = null
)