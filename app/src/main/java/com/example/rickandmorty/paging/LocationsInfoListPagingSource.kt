package com.example.rickandmorty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.api.LocationsApiService
import com.example.rickandmorty.data.pojo.LocationInfo

class LocationsInfoListPagingSource(private val locationsApiService: LocationsApiService) :
    PagingSource<Int, LocationInfo>() {
    override fun getRefreshKey(state: PagingState<Int, LocationInfo>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationInfo> {
        return try {
            val currentPage = params.key ?: 1
            val response = locationsApiService.getLocationsInfoList(currentPage)
            val responseData = mutableListOf<LocationInfo>()
            //val data = response.body()?.results ?: emptyList()
            //responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(throwable = e)
        }
    }
}