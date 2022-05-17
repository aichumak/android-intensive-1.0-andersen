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

class CharacterListViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repository = CharactersRepositoryImpl
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    private val getFilteredCharactersUseCase = GetFilteredCharactersUseCase(repository)

    val charactersList = MutableLiveData<List<CharacterObject>>()

    fun updateRequiredCharacters(arrayList: ArrayList<String>?) {
        viewModelScope.launch {
            charactersList.value = getAllCharactersUseCase.getAllCharacters(arrayList)
        }
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        viewModelScope.launch {
            charactersList.value = if (filterParameters == null) {
                getAllCharactersUseCase.getAllCharacters(filterParameters)
            } else {
                getFilteredCharactersUseCase.getFilteredCharacters(filterParameters)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}