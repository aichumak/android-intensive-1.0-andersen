package com.example.rickandmorty.domain.characters

class GetCharacterUseCase(private val charactersRepository: CharactersRepository) {
     fun getCharacter(id: Int): CharacterObject {
        return charactersRepository.getCharacter(id)
    }
}