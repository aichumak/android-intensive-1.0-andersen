package com.example.rickandmorty.domain.characters

class GetAllCharactersUseCase(private val charactersRepository: CharactersRepository) {
    fun getAllCharacters(){
        charactersRepository.getAllCharacters()
    }
}