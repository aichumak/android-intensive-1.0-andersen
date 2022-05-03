package com.example.rickandmorty.api

import com.example.rickandmorty.pojo.CharacterInfo
import com.example.rickandmorty.pojo.CharactersInfoListOfResult
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApiService {
    @GET("character/")
    fun getCharacterInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<CharacterInfo>

    @GET("character")
    fun getCharactersInfoList(
        @Query("page") page: Int
    ): Response<CharactersInfoListOfResult>

    companion object {
        private const val QUERY_PARAM_ID = "id"
    }

}