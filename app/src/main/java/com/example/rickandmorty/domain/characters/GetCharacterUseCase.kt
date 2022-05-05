package com.example.rickandmorty.domain.characters

class GetCharacterUseCase(private val charactersRepository: CharactersRepository) {
    suspend fun getCharacter(id: Int) {
        charactersRepository.getCharacter(id)
    }
}