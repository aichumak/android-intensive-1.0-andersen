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

class CharacterListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    private val repository = CharactersRepositoryImpl
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    private val getFilteredCharactersUseCase = GetFilteredCharactersUseCase(repository)
    private var arrayCharacters: ArrayList<String>? = null

    //var charactersList = getAllCharactersUseCase.getAllCharacters(arrayCharacters)
    var charactersList: LiveData<List<CharacterObject>>? = null

    fun updateRequiredCharacters(arrayList: ArrayList<String>?) {
        arrayCharacters = arrayList
        charactersList = getAllCharactersUseCase.getAllCharacters(arrayCharacters)
    }

    fun getFilteredData(filterParameters: Pair<String, String>?) {
        charactersList = if (filterParameters == null) {
            val array = arrayListOf("https://rickandmortyapi.com/api/character/1")
            getAllCharactersUseCase.getAllCharacters(array)
        } else {
            getFilteredCharactersUseCase.getFilteredCharacters(filterParameters)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}