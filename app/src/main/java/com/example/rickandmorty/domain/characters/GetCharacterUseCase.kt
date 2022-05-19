package com.example.rickandmorty.domain.characters

class GetCharacterUseCase(private val charactersRepository: CharactersRepository) {
    suspend fun getCharacter(id: Int): CharacterObject {
        return charactersRepository.getCharacter(id)
    }
}