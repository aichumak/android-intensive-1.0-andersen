package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData

class GetFilteredCharactersUseCase(private val charactersRepository: CharactersRepository) {
     fun getFilteredCharacters(filterParameters: Pair<String, String>): LiveData<List<CharacterObject>> {
        return charactersRepository.getFilteredCharacters(filterParameters)
    }
}