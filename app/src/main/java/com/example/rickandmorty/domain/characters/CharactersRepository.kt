package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.pojo.CharacterInfoModel

interface CharactersRepository {
    suspend fun getAllCharacters(limit: Int, offset: Int): LiveData<List<CharacterObject>>
    suspend fun getCharacter(id: Int): CharacterObject
    suspend fun addCharacter(character: CharacterInfoModel)
    suspend fun getFilteredCharacter()
}