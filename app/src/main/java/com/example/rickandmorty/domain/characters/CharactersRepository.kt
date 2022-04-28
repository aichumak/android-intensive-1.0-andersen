package com.example.rickandmorty.domain.characters

interface CharactersRepository {
    fun getAllCharacters()
    fun getSingleCharacter()
    fun getFilteredCharacter()
}