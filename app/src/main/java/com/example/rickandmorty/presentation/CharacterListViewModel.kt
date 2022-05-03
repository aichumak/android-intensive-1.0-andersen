package com.example.rickandmorty.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.example.rickandmorty.domain.characters.GetFilteredCharacterUseCase
import com.example.rickandmorty.domain.characters.GetSingleCharacterUseCase

class CharacterListViewModel(context: Context): ViewModel() {
    private val repository = CharactersRepositoryImpl(context)
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    private val getSingleCharacterUseCase = GetSingleCharacterUseCase(repository)
    private val getFilteredCharacterUseCase = GetFilteredCharacterUseCase(repository)


}