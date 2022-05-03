package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.pojo.CharacterInfo
import com.example.rickandmorty.pojo.CharactersInfoListOfResult

@Dao
interface CharactersInfoDao {
    @Query("SELECT * FROM characters_list ORDER BY id")
    fun getCharactersInfoList(): List<CharacterInfo>

    @Query("SELECT * FROM characters_list WHERE id== :characterId")
    fun getCharacterInfo(characterId: Int): CharacterInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharactersInfoList(charactersList: List<CharacterInfo>)
}