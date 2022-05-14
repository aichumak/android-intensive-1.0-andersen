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
        "SELECT * FROM characters_list ORDER BY id"
    )
    fun getCharactersInfoList(): LiveData<List<CharacterInfoModel>>

    @Query("SELECT * FROM characters_list WHERE id=:characterId")
    suspend fun getCharacterInfo(characterId: Int): CharacterInfoModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addCharacterList(characterList: List<CharacterInfoModel>)
}