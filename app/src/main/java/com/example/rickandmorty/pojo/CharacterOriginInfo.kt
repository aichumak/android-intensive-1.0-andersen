package com.example.rickandmorty.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CharacterOriginInfo(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("url")
    @Expose
    val url: String
)