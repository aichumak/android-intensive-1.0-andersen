package com.example.rickandmorty.api

import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.data.pojo.CharactersInfoListOfResult
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApiService {
    @GET("character")
    suspend fun getCharacterInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<CharacterInfoModel>

    @GET("character")
    suspend fun getCharactersInfoList(
        @Query("page") page: Int
    ): Response<CharactersInfoListOfResult>

    companion object {
        private const val QUERY_PARAM_ID = "id"
    }

}