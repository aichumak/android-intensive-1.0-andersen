package com.example.rickandmorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetCharacterUseCase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import java.util.*

class CharacterViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repository = CharactersRepositoryImpl
    private val getSingleCharacterUseCase = GetCharacterUseCase(repository)

    val character = MutableLiveData<CharacterObject>()

    fun getSingleCharacter(position: Int) {
        viewModelScope.launch {
            val item = getSingleCharacterUseCase.getCharacter(position+1)
            character.value = item
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}