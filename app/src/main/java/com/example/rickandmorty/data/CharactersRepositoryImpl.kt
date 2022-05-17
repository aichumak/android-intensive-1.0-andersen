package com.example.rickandmorty.data

import android.util.Log
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

    override suspend fun getAllCharacters(arrayList: ArrayList<String>?): List<CharacterObject> {
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

    override suspend fun getFilteredCharacters(filterParameters: Pair<String, String>): List<CharacterObject> {
        return mapper.mapListDataBaseModelToListEntity(
            when (filterParameters.first) {
                "name" -> charactersInfoDao.getNameFilteredCharactersInfoList(filterParameters.second)
                "status" -> charactersInfoDao.getStatusFilteredCharactersInfoList(filterParameters.second)
                "species" -> charactersInfoDao.getSpeciesFilteredCharactersInfoList(filterParameters.second)
                "type" -> charactersInfoDao.getTypeFilteredCharactersInfoList(filterParameters.second)
                "gender" -> charactersInfoDao.getGenderFilteredCharactersInfoList(filterParameters.second)
                else -> throw Exception()
            }
        )
    }
}