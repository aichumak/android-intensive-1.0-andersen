package com.example.rickandmorty.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CharactersInfoListOfResult (
    @SerializedName("results")
    @Expose
    private val results: List<CharacterInfo>? = null
)