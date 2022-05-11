package com.example.rickandmorty.domain.characters

data class CharacterLocation(
    val name: String,
    val url: String
){
    override fun toString(): String {
        return ("$name, $url")
    }
}