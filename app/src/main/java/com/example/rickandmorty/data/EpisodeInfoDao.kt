package com.example.rickandmorty.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.pojo.EpisodeInfo

@Dao
interface EpisodeInfoDao {
    @Query(
        "SELECT * FROM episodes_list ORDER BY id " +
                "LIMIT :limit " +
                "OFFSET :offset"
    )
    fun getEpisodesInfoList(limit: Int, offset: Int): List<EpisodeInfo>

    @Query("SELECT * FROM episodes_list WHERE id== :episodeId")
    fun getEpisodeInfo(episodeId: Int): EpisodeInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodesInfo(episodesInfoList: List<EpisodeInfo>)
}