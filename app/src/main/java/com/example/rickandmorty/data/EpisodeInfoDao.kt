package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.pojo.EpisodeInfoModel

@Dao
interface EpisodeInfoDao {
    @Query("SELECT * FROM episodes_list ORDER BY id")
    suspend fun getAllEpisodesInfoList(): List<EpisodeInfoModel>

    @Query("SELECT * FROM episodes_list WHERE url IN (:arrayList) ORDER BY id")
    suspend fun getRequiredEpisodesInfoList(arrayList: ArrayList<String>): List<EpisodeInfoModel>

    @Query("SELECT * FROM episodes_list WHERE id=:episodeId")
    suspend fun getEpisodeInfo(episodeId: Int): EpisodeInfoModel

    @Query("SELECT * FROM episodes_list WHERE name LIKE :valueForSearch ORDER BY id")
    suspend fun getNameFilteredEpisodesInfoList(valueForSearch: String): List<EpisodeInfoModel>

    @Query("SELECT * FROM episodes_list WHERE episode LIKE :valueForSearch ORDER BY id")
    suspend fun getEpisodeFilteredEpisodesInfoList(valueForSearch: String): List<EpisodeInfoModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodesInfo(episodesInfoList: List<EpisodeInfoModel>)
}