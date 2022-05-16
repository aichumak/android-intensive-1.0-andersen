package com.example.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.example.rickandmorty.domain.characters.GetFilteredCharactersUseCase
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import kotlin.collections.ArrayList

class CharacterListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = CharactersRepositoryImpl
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    private val getFilteredCharactersUseCase = GetFilteredCharactersUseCase(repository)
    private var arrayCharacters: ArrayList<String>? = null

    val charactersList = MutableLiveData<List<CharacterObject>>()
    private val prevCharactersList = MutableLiveData<List<CharacterObject>>()

    fun updateRequiredCharacters(arrayList: ArrayList<String>?) {
        arrayCharacters = arrayList
        charactersList.value = getAllCharactersUseCase.getAllCharacters(arrayCharacters).value // as MutableLiveData<List<CharacterObject>>
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        charactersList.value = if (filterParameters == null) {
            getAllCharactersUseCase.getAllCharacters(filterParameters).value
        } else {
            getFilteredCharactersUseCase.getFilteredCharacters(filterParameters).value
        }
    }

    fun replaceListForSearch(newList: TreeSet<CharacterObject>) {
        prevCharactersList.value = charactersList.value
        charactersList.value = newList.toList()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}