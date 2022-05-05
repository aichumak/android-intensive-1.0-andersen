package com.example.rickandmorty.domain.characters

class GetFilteredCharacterUseCase(private val charactersRepository: CharactersRepository) {
    suspend fun getFilteredCharacter() {
        charactersRepository.getFilteredCharacter()
    }
}