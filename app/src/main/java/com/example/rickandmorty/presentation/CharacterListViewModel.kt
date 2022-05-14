package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import io.reactivex.disposables.CompositeDisposable

class CharacterListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = CharactersRepositoryImpl
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    private var arrayCharacters: ArrayList<String>? = null

    val charactersList = getAllCharactersUseCase.getAllCharacters(arrayCharacters)

    fun updateArrayCharacters(arrayList: ArrayList<String>?) {
        arrayCharacters = arrayList
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}