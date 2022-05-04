package com.example.rickandmorty.domain.characters

class GetAllCharactersUseCase(private val charactersRepository: CharactersRepository) {
    fun getAllCharacters(limit: Int, offset: Int) {
        charactersRepository.getAllCharacters(limit, offset)
    }
}