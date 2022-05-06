package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.pojo.CharacterInfoModel

interface CharactersRepository {
     fun getAllCharacters(limit: Int, offset: Int): LiveData<List<CharacterObject>>
     fun getCharacter(id: Int): CharacterObject
     fun addCharacter(character: CharacterInfoModel)
     fun getFilteredCharacter()
}