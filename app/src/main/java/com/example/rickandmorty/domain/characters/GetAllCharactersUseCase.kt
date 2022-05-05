package com.example.rickandmorty.domain.characters

import androidx.lifecycle.LiveData

class GetAllCharactersUseCase(private val charactersRepository: CharactersRepository) {
    suspend fun getAllCharacters(limit: Int, offset: Int): LiveData<List<CharacterObject>> {
        return charactersRepository.getAllCharacters(limit, offset)
    }
}