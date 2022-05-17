package com.example.rickandmorty.domain.characters

class GetAllCharactersUseCase(private val charactersRepository: CharactersRepository) {
    suspend fun getAllCharacters(arrayList: ArrayList<String>?): List<CharacterObject> {
        return charactersRepository.getAllCharacters(arrayList)
    }
}