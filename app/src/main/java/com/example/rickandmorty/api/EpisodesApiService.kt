package com.example.rickandmorty.api

import com.example.rickandmorty.data.pojo.EpisodeInfo
import com.example.rickandmorty.data.pojo.EpisodeResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodesApiService {
    @GET("episode")
    fun getEpisodeInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<EpisodeInfo>

    @GET("episode")
    fun getEpisodesInfoList(
        @Query("page") page: Int
    ): Single<EpisodeResult>

    companion object {
        private const val QUERY_PARAM_ID = "id"
    }
}