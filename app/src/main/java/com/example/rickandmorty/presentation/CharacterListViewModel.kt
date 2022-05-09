package com.example.rickandmorty.presentation

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.example.rickandmorty.domain.characters.GetFilteredCharacterUseCase
import com.example.rickandmorty.domain.characters.GetCharacterUseCase
import kotlinx.coroutines.launch

class CharacterListViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CharactersRepositoryImpl(application)
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    private val getSingleCharacterUseCase = GetCharacterUseCase(repository)
    private val getFilteredCharacterUseCase = GetFilteredCharacterUseCase(repository)


    val charactersList = getAllCharactersUseCase.getAllCharacters(5, 20)


//    private fun getCharacters(): String {
//        var list: Any? =null
//        viewModelScope.launch {
//            val list = getAllCharactersUseCase.getAllCharacters(1, 20)
//            val a = 0
//        }
//        return ""
//    }




}