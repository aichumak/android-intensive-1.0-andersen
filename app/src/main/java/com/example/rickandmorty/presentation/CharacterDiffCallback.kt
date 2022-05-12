package com.example.rickandmorty.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.domain.characters.CharacterObject

class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterObject>() {
    override fun areItemsTheSame(
        oldCharacter: CharacterObject,
        newCharacter: CharacterObject
    ): Boolean {
        return oldCharacter.id == newCharacter.id
    }

    override fun areContentsTheSame(
        oldCharacter: CharacterObject,
        newCharacter: CharacterObject
    ): Boolean {
        return oldCharacter == newCharacter
    }
}