package com.example.rickandmorty.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.rickandmorty.api.CharactersApiFactory
import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.CharactersRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharactersRepositoryImpl(context: Context, compositeDisposable: CompositeDisposable) :
    CharactersRepository {

    private val charactersInfoDao = CharactersDataBase.getInstance(context).characterInfoDao()
    private val mapper = CharactersListMapper()

    init {
       for (i in 1..42) {
            val disposable = CharactersApiFactory.apiService.getCharactersInfoList(i)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    if (it != null) {
                        it.results?.let { results ->
                            addCharacterList(mapper.mapListEntityToListDataBaseModel(results))
                            Log.d("tst", "Load $i")
                        }

                    }
                }, {

                })

            compositeDisposable.add(disposable)
        }
    }

    override fun getAllCharacters(): LiveData<List<CharacterObject>> {
        return mapper.mapListDataBaseModelToListEntity(charactersInfoDao.getCharactersInfoList())
    }

    override fun getCharacter(id: Int): CharacterObject {
        val character = charactersInfoDao.getCharacterInfo(id)
        return mapper.mapDataBaseModelToEntity(character)
    }

    override fun addCharacterList(characterList: List<CharacterInfoModel>) {
        charactersInfoDao.addCharacterList(characterList)
    }

    override fun getFilteredCharacter() {
        TODO("Not yet implemented")
    }

}