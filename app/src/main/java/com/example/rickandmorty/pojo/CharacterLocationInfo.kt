package com.example.rickandmorty.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CharacterLocationInfo(
    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null
)