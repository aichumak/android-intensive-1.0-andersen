package com.example.rickandmorty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject

class CharactersInfoListPagingSource(private val charactersRepositoryImpl: CharactersRepositoryImpl) :
    PagingSource<Int, CharacterObject>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterObject>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterObject> {
        return try {
            val currentPage = params.key ?: 1
            //val response = charactersRepositoryImpl.getAllCharacters(currentPage, 20)
            val responseData = mutableListOf<CharacterObject>()
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