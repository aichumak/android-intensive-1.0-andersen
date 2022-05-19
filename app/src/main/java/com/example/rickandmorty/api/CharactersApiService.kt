package com.example.rickandmorty.api

import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.data.pojo.CharacterResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApiService {
    @GET("character")
    fun getCharacterInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<CharacterInfoModel>

    @GET("character")
    fun getCharactersInfoList(
        @Query("page") page: Int
    ): Single<CharacterResult>

    companion object {
        private const val QUERY_PARAM_ID = "id"
    }

}