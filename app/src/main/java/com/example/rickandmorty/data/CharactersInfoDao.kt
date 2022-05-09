package com.example.rickandmorty.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.pojo.CharacterInfoModel

@Dao
interface CharactersInfoDao {
    @Query(
        "SELECT * FROM characters_list ORDER BY id " +
                "LIMIT :limit " +
                "OFFSET :offset"
    )
    fun getCharactersInfoList(limit: Int, offset: Int): LiveData<List<CharacterInfoModel>>

    @Query(
        "SELECT * FROM characters_list ORDER BY id "
    )
    fun getCharactersInfoListTest(): LiveData<List<CharacterInfoModel>>

    @Query("SELECT * FROM characters_list WHERE id== :characterId")
    fun getCharacterInfo(characterId: Int): CharacterInfoModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addCharacterInfoModel(characterInfoModel: CharacterInfoModel)
}