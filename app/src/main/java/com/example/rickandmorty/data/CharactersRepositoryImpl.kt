package com.example.rickandmorty.data

import android.content.Context
import com.example.rickandmorty.domain.characters.CharactersRepository
import com.example.rickandmorty.pojo.CharacterInfo

class CharactersRepositoryImpl(context: Context): CharactersRepository {

    private val charactersDataBase = CharactersDataBase.getInstance(context)

    override fun getAllCharacters(limit: Int, offset: Int): List<CharacterInfo> {
        return charactersDataBase.characterInfoDao().getCharactersInfoList(limit, offset)
    }

    override fun getSingleCharacter(id: Int): CharacterInfo {
        return charactersDataBase.characterInfoDao().getCharacterInfo(id)
    }

    override fun getFilteredCharacter() {
        TODO("Not yet implemented")
    }
}