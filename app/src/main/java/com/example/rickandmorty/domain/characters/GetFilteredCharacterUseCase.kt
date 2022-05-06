package com.example.rickandmorty.domain.characters

class GetFilteredCharacterUseCase(private val charactersRepository: CharactersRepository) {
     fun getFilteredCharacter() {
        charactersRepository.getFilteredCharacter()
    }
}