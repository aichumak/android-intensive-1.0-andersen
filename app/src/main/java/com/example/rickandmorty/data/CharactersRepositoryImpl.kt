package com.example.rickandmorty.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.rickandmorty.api.CharactersApiFactory
import com.example.rickandmorty.domain.characters.CharactersRepository
import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.domain.characters.CharacterObject

class CharactersRepositoryImpl(context: Context): CharactersRepository {

    private val charactersInfoDao = CharactersDataBase.getInstance(context).characterInfoDao()
    private val mapper = CharactersListMapper()
    private val apiFactory = CharactersApiFactory

    override suspend fun getAllCharacters(limit: Int, offset: Int): LiveData<List<CharacterObject>> {
        val characters = apiFactory.apiService.getCharactersInfoList(limit)

        val result = charactersInfoDao.getCharactersInfoList(limit, offset)
        result.value?.forEach {
            addCharacter(it)
        }
        return Transformations.map(result) {
            mapper.mapListDataBaseModelToListEntity(it)
        }
    }

    override suspend fun getCharacter(id: Int): CharacterObject {
        val character = charactersInfoDao.getCharacterInfo(id)
        return mapper.mapDataBaseModelToEntity(character)
    }

    override suspend fun addCharacter(character: CharacterInfoModel) {
        charactersInfoDao.addCharacterInfoModel(character)
    }

    override suspend fun getFilteredCharacter() {
        TODO("Not yet implemented")
    }
}