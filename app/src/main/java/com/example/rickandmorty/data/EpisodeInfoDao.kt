package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.pojo.EpisodeInfo
import com.example.rickandmorty.data.pojo.EpisodeInfoModel

@Dao
interface EpisodeInfoDao {
    @Query(
        "SELECT * FROM episodes_list ORDER BY id " +
                "LIMIT :limit " +
                "OFFSET :offset"
    )
    fun getEpisodesInfoList(limit: Int, offset: Int): List<EpisodeInfoModel>

    @Query("SELECT * FROM episodes_list WHERE id== :episodeId")
    fun getEpisodeInfo(episodeId: Int): EpisodeInfoModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodesInfo(episodesInfoList: List<EpisodeInfoModel>)
}