package com.example.rickandmorty.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.data.pojo.EpisodeInfo
import com.example.rickandmorty.data.pojo.EpisodeInfoModel

@Dao
interface EpisodeInfoDao {
    @Query(
        "SELECT * FROM episodes_list ORDER BY id "
    )
    fun getAllEpisodesInfoList(): LiveData<List<EpisodeInfoModel>>

    @Query(
        "SELECT * FROM episodes_list WHERE url IN (:arrayList) ORDER BY id "
    )
    fun getRequiredEpisodesInfoList(arrayList: ArrayList<String>): LiveData<List<EpisodeInfoModel>>

    @Query("SELECT * FROM episodes_list WHERE id=:episodeId")
    suspend fun getEpisodeInfo(episodeId: Int): EpisodeInfoModel

    @Query("SELECT * FROM episodes_list WHERE :fieldToSearch LIKE :valueForSearch")
    fun getFilteredEpisodesInfoList(
        fieldToSearch: String,
        valueForSearch: String
    ): LiveData<List<EpisodeInfoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodesInfo(episodesInfoList: List<EpisodeInfoModel>)
}