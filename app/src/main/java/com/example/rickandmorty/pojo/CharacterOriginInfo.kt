package com.example.rickandmorty.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CharacterOriginInfo (
    @SerializedName("name")
    @Expose
    private val name: String? = null,

    @SerializedName("url")
    @Expose
    private val url: String? = null
)