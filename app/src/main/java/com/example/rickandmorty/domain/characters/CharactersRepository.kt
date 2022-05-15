package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.pojo.CharacterInfoModel

interface CharactersRepository {
     fun getAllCharacters(arrayList: ArrayList<String>?): LiveData<List<CharacterObject>>
     suspend fun getCharacter(id: Int): CharacterObject
     fun addCharacterList(characterList: List<CharacterInfoModel>)
     fun getFilteredCharacter()
}