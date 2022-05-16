package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.pojo.CharacterInfoModel

interface CharactersRepository {
     fun getAllCharacters(arrayList: ArrayList<String>?): LiveData<List<CharacterObject>>
     fun getFilteredCharacters(filterParameters: Pair<String, String>): LiveData<List<CharacterObject>>
     suspend fun getCharacter(id: Int): CharacterObject
     fun addCharacterList(characterList: List<CharacterInfoModel>)
}