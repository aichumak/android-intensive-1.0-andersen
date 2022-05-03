package com.example.rickandmorty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.api.CharactersApiService
import com.example.rickandmorty.pojo.CharacterInfo

class CharactersInfoListPagingSource(private val charactersApiService: CharactersApiService) :
    PagingSource<Int, CharacterInfo>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterInfo>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterInfo> {
        return try {
            val currentPage = params.key ?: 1
            val response = charactersApiService.getCharactersInfoList(currentPage)
            val responseData = mutableListOf<CharacterInfo>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

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