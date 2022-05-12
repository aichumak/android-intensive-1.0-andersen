package com.example.rickandmorty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.api.EpisodesApiService
import com.example.rickandmorty.data.pojo.EpisodeInfo

class EpisodesInfoListPagingSource(private val episodesApiService: EpisodesApiService) :
    PagingSource<Int, EpisodeInfo>() {

    override fun getRefreshKey(state: PagingState<Int, EpisodeInfo>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeInfo> {
        return try {
            val currentPage = params.key ?: 1
            val response = episodesApiService.getEpisodesInfoList(currentPage)
            val responseData = mutableListOf<EpisodeInfo>()
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
