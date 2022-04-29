package com.example.rickandmorty.api

import com.example.rickandmorty.pojo.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApiService {
    @GET
    fun getCharacterInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<CharacterInfo>

    @GET
    fun getCharactersInfoList(): Single<CharactersInfoListOfResult>

    companion object{
        private const val QUERY_PARAM_ID = "id"
    }
}