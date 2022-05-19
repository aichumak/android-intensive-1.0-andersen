package com.example.rickandmorty.data.pojo

import com.example.rickandmorty.domain.characters.CharacterObject
import com.google.gson.annotations.Expose

data class CharacterResult(
    @Expose
    val results: List<CharacterObject>? = null,
    val info: CharacterInfo? = null
)