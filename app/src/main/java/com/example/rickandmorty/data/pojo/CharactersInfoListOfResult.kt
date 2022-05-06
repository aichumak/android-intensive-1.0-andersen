package com.example.rickandmorty.data.pojo

import com.google.gson.JsonArray
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CharactersInfoListOfResult(
    //@SerializedName("results")
    //@Expose
    val results: List<CharacterInfoModel>
)