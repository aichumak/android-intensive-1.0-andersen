package com.example.rickandmorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.example.rickandmorty.domain.characters.GetFilteredCharactersUseCase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import java.util.*

class CharacterListViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repository = CharactersRepositoryImpl
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    private val getFilteredCharactersUseCase = GetFilteredCharactersUseCase(repository)

    val charactersList = MutableLiveData<List<CharacterObject>>()
    private val charactersListFromDb = MutableLiveData<List<CharacterObject>>()

    fun restoreCharactersList() {
        charactersList.value = charactersListFromDb.value
    }

    fun updateRequiredCharacters(arrayList: ArrayList<String>?) {
        viewModelScope.launch {
            charactersListFromDb.value = getAllCharactersUseCase.getAllCharacters(arrayList)
            restoreCharactersList()
        }
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        viewModelScope.launch {
            charactersListFromDb.value = if (filterParameters == null) {
                getAllCharactersUseCase.getAllCharacters(filterParameters)
            } else {
                getFilteredCharactersUseCase.getFilteredCharacters(filterParameters)
            }
            restoreCharactersList()
        }
    }

    fun replaceListForSearch(newList: TreeSet<CharacterObject>) {
        charactersList.value = newList.toList()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}