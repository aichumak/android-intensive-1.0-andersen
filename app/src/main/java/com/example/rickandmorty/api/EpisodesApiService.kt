package com.example.rickandmorty.api

import com.example.rickandmorty.pojo.EpisodeInfo
import com.example.rickandmorty.pojo.EpisodesInfoListOfResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodesApiService {
    @GET
    fun getEpisodeInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<EpisodeInfo>

    @GET()
    fun getEpisodesInfoList(): Single<EpisodesInfoListOfResult>

    companion object {
        private const val QUERY_PARAM_ID = "id"
    }
}