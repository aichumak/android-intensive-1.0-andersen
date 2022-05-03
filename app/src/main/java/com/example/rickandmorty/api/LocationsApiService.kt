package com.example.rickandmorty.api

import com.example.rickandmorty.pojo.LocationInfo
import com.example.rickandmorty.pojo.LocationsInfoListOfResult
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationsApiService {
    @GET("location/")
    fun getLocationInfo(
        @Query(QUERY_PARAM_ID) id: Int
    ): Single<LocationInfo>

    @GET("location")
    fun getLocationsInfoList(
        @Query("page") page: Int
    ): Response<LocationsInfoListOfResult>

    companion object {
        private const val QUERY_PARAM_ID = "id"
    }
}