package com.example.rickandmorty.domain.characters

import com.example.rickandmorty.data.pojo.CharacterInfoModel

class AddCharacterList(private val charactersRepository: CharactersRepository) {
    fun addCharacterList(characterList: List<CharacterInfoModel>) {
        return charactersRepository.addCharacterList(characterList)
    }
}