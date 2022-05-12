package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData

class GetAllCharactersUseCase(private val charactersRepository: CharactersRepository) {
     fun getAllCharacters(): LiveData<List<CharacterObject>> {
        return charactersRepository.getAllCharacters()
    }
}