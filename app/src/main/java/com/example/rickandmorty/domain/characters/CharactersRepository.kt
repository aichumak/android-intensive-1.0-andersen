package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.pojo.CharacterInfoModel

interface CharactersRepository {
     fun getAllCharacters(): LiveData<List<CharacterObject>>
     fun getCharacter(id: Int): CharacterObject
     fun addCharacterList(characterList: List<CharacterInfoModel>)
     fun getFilteredCharacter()
}