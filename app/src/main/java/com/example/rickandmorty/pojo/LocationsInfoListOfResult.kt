package com.example.rickandmorty.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LocationsInfoListOfResult(
    @SerializedName("results")
    @Expose
    val results: List<CharacterInfo>? = null
)
