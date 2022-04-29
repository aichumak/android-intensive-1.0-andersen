package com.example.rickandmorty.api

import com.example.rickandmorty.pojo.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character/")
    fun getCharacterInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<CharacterInfo>

    @GET("location/")
    fun getLocationInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<LocationInfo>

    @GET("episode/")
    fun getEpisodeInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<EpisodeInfo>

    @GET("character")
    fun getCharactersInfoList(): Single<CharactersInfoListOfResult>

    @GET("location")
    fun getLocationsInfoList(): Single<LocationsInfoListOfResult>

    @GET("episode")
    fun getEpisodesInfoList(): Single<EpisodesInfoListOfResult>

    companion object{
        private const val QUERY_PARAM_ID = "id"
    }
}