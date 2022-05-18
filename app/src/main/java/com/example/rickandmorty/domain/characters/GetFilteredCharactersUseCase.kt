package com.example.rickandmorty.domain.characters

class GetFilteredCharactersUseCase(private val charactersRepository: CharactersRepository) {
    suspend fun getFilteredCharacters(filterParameters: Pair<String, String>): List<CharacterObject> {
        return charactersRepository.getFilteredCharacters(filterParameters)
    }
}