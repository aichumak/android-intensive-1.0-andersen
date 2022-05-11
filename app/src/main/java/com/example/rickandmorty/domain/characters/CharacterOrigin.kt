package com.example.rickandmorty.domain.characters

data class CharacterOrigin(
    val name: String,
    val url: String


) {
    override fun toString(): String {
        return ("$name, $url")
    }
}