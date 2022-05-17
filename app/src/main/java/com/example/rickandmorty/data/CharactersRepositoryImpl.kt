package com.example.rickandmorty.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.rickandmorty.api.CharactersApiFactory
import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.CharactersRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

object CharactersRepositoryImpl : CharactersRepository {

    private val charactersInfoDao = CharactersDataBase.getInstance().characterInfoDao()
    private val mapper = CharactersListMapper()
    private val compositeDisposable = CompositeDisposable()

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

    override fun getAllCharacters(arrayList: ArrayList<String>?): LiveData<List<CharacterObject>> {
        return mapper.mapListDataBaseModelToListEntity(
            if (arrayList == null) {
                charactersInfoDao.getAllCharactersInfoList()
            } else {
                charactersInfoDao.getRequiredCharactersInfoList(arrayList)
            }
        )
    }

    override suspend fun getCharacter(id: Int): CharacterObject {
        val character = charactersInfoDao.getCharacterInfo(id)
        return mapper.mapDataBaseModelToObjectEntity(character)
    }

    override fun addCharacterList(characterList: List<CharacterInfoModel>) {
        charactersInfoDao.addCharacterList(characterList)
    }

    override fun getFilteredCharacters(filterParameters: Pair<String, String>): LiveData<List<CharacterObject>> {
        return mapper.mapListDataBaseModelToListEntity(
            charactersInfoDao.getFilteredCharactersInfoList(
                filterParameters.first.toString(),
                filterParameters.second.toString()
            )
        )
    }
}