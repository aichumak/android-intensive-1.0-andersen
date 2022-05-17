package com.example.rickandmorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.data.LocationsRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetCharacterUseCase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val charactersRepository = CharactersRepositoryImpl
    private val getSingleCharacter = GetCharacterUseCase(charactersRepository)

    val character = MutableLiveData<CharacterObject>()

    fun getSingleCharacter(itemId: Int) {
        viewModelScope.launch {
            val item = getSingleCharacter.getCharacter(itemId)
            character.value = item
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}