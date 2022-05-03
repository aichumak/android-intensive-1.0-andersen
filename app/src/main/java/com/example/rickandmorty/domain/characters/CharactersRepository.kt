package com.example.rickandmorty.domain.characters

import android.content.Context
import com.example.rickandmorty.pojo.CharacterInfo

interface CharactersRepository {
    fun getAllCharacters(limit: Int, offset: Int): List<CharacterInfo>
    fun getSingleCharacter(id: Int): CharacterInfo
    fun getFilteredCharacter()
}