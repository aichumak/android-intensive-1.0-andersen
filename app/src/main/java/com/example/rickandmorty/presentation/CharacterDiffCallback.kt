package com.example.rickandmorty.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.domain.characters.CharacterObject

class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterObject>() {
    override fun areItemsTheSame(
        oldContact: CharacterObject,
        newContact: CharacterObject
    ): Boolean {
        return oldContact.id == newContact.id
    }

    override fun areContentsTheSame(
        oldContact: CharacterObject,
        newContact: CharacterObject
    ): Boolean {
        return oldContact == newContact
    }
}