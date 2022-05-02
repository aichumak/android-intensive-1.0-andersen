package com.example.rickandmorty.domain.characters

class GetSingleCharacterUseCase(private val charactersRepository: CharactersRepository) {
    fun getSingleCharacter() {
        charactersRepository.getSingleCharacter()
    }
}