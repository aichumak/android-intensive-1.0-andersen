package com.example.rickandmorty.domain.characters

import com.example.rickandmorty.data.pojo.CharacterInfoModel

interface CharactersRepository {
    suspend fun getAllCharacters(arrayList: ArrayList<String>?): List<CharacterObject>
    suspend fun getFilteredCharacters(filterParameters: Pair<String, String>): List<CharacterObject>
    suspend fun getCharacter(id: Int): CharacterObject
    fun addCharacterList(characterList: List<CharacterInfoModel>)
}