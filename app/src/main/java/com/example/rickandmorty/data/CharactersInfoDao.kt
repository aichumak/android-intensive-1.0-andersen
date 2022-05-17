package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.pojo.CharacterInfoModel

@Dao
interface CharactersInfoDao {

    @Query("SELECT * FROM characters_list ORDER BY id")
    suspend fun getAllCharactersInfoList(): List<CharacterInfoModel>

    @Query("SELECT * FROM characters_list WHERE url IN (:arrayList) ORDER BY id")
    suspend fun getRequiredCharactersInfoList(arrayList: ArrayList<String>): List<CharacterInfoModel>

    @Query("SELECT * FROM characters_list WHERE name LIKE :valueForSearch ORDER BY id")
    suspend fun getNameFilteredCharactersInfoList(valueForSearch: String): List<CharacterInfoModel>

    @Query("SELECT * FROM characters_list WHERE status LIKE :valueForSearch ORDER BY id")
    suspend fun getStatusFilteredCharactersInfoList(valueForSearch: String): List<CharacterInfoModel>

    @Query("SELECT * FROM characters_list WHERE species LIKE :valueForSearch ORDER BY id")
    suspend fun getSpeciesFilteredCharactersInfoList(valueForSearch: String): List<CharacterInfoModel>

    @Query("SELECT * FROM characters_list WHERE type LIKE :valueForSearch ORDER BY id")
    suspend fun getTypeFilteredCharactersInfoList(valueForSearch: String): List<CharacterInfoModel>

    @Query("SELECT * FROM characters_list WHERE gender LIKE :valueForSearch ORDER BY id")
    suspend fun getGenderFilteredCharactersInfoList(valueForSearch: String): List<CharacterInfoModel>

    @Query("SELECT * FROM characters_list WHERE id=:characterId")
    suspend fun getCharacterInfo(characterId: Int): CharacterInfoModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacterList(characterList: List<CharacterInfoModel>)
}