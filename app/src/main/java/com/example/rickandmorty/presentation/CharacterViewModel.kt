package com.example.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetCharacterUseCase
import io.reactivex.disposables.CompositeDisposable

class CharacterViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repository = CharactersRepositoryImpl
    private val getSingleCharacterUseCase = GetCharacterUseCase(repository)

    fun getSingleCharacter(id: Int): CharacterObject {
        return getSingleCharacterUseCase.getCharacter(id)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}