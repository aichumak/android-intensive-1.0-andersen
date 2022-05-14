package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.example.rickandmorty.domain.characters.GetFilteredCharacterUseCase
import com.example.rickandmorty.domain.characters.GetCharacterUseCase
import io.reactivex.disposables.CompositeDisposable

class CharacterListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    val repository = CharactersRepositoryImpl
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    //private val getSingleCharacterUseCase = GetCharacterUseCase(repository)
    //private val getFilteredCharacterUseCase = GetFilteredCharacterUseCase(repository)

    val charactersList = getAllCharactersUseCase.getAllCharacters()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}