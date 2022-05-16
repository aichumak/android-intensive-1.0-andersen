package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData

class GetAllCharactersUseCase(private val charactersRepository: CharactersRepository) {
    fun getAllCharacters(arrayList: ArrayList<String>?): LiveData<List<CharacterObject>> {
        return charactersRepository.getAllCharacters(arrayList)
    }
}