package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.example.rickandmorty.domain.characters.GetFilteredCharactersUseCase
import io.reactivex.disposables.CompositeDisposable

class CharacterListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = CharactersRepositoryImpl
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    private val getFilteredCharactersUseCase = GetFilteredCharactersUseCase(repository)

    var charactersList: LiveData<List<CharacterObject>>? = null

    fun updateRequiredCharacters(arrayList: ArrayList<String>?) {
        charactersList = getAllCharactersUseCase.getAllCharacters(arrayList)
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        charactersList = if (filterParameters == null) {
            getAllCharactersUseCase.getAllCharacters(filterParameters)
        } else {
            getFilteredCharactersUseCase.getFilteredCharacters(filterParameters)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}