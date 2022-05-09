package com.example.rickandmorty.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.rickandmorty.api.CharactersApiFactory
import com.example.rickandmorty.domain.characters.CharactersRepository
import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.domain.characters.CharacterObject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharactersRepositoryImpl(context: Context): CharactersRepository {

    private val charactersInfoDao = CharactersDataBase.getInstance(context).characterInfoDao()
    private val mapper = CharactersListMapper()
    private val apiFactory = CharactersApiFactory
    private val compositeDisposable = CompositeDisposable()


    override fun getAllCharacters(limit: Int, offset: Int): LiveData<List<CharacterObject>> {

        val disposable = CharactersApiFactory.apiService.getCharactersInfoList(limit)
            .subscribeOn(Schedulers.io())
            .subscribe({characterResult ->
                if (characterResult != null) {
                    characterResult.results?.forEach {
                    charactersInfoDao.addCharacterInfoModel(mapper.mapEntityToDataBaseModel(it))
                    }
                    //db.coinPriceInfoDao().insertPriceList(it)
                    //Log.d("Test_of_loading_data", it.toString())
                }
            }, {
                //Log.d("Test_of_loading_data", it.message.toString())
            })
        compositeDisposable.add(disposable)

//        try {
//        val characters = apiFactory.apiService.getCharactersInfoList(limit)
//
//        } catch (e: Exception ){
//            val df= e
//        }
//
//        val result = charactersInfoDao.getCharactersInfoList(limit, offset)
//        result.value?.forEach {
//            addCharacter(it)
//        }
        val a = charactersInfoDao.getCharactersInfoList(limit, offset)
        val ab = charactersInfoDao.getCharactersInfoListTest()
        val b = mapper.mapListDataBaseModelToListEntity(charactersInfoDao.getCharactersInfoList(limit, offset))
        return mapper.mapListDataBaseModelToListEntity(charactersInfoDao.getCharactersInfoList(limit, offset))

        //Transformations.map(result) {
        //    mapper.mapListDataBaseModelToListEntity(charactersInfoDao.getCharactersInfoList(5, 20))
        //}
    }

    override fun getCharacter(id: Int): CharacterObject {
        val character = charactersInfoDao.getCharacterInfo(id)
        return mapper.mapDataBaseModelToEntity(character)
    }

    override fun addCharacter(character: CharacterInfoModel) {
        charactersInfoDao.addCharacterInfoModel(character)
    }

    override fun getFilteredCharacter() {
        TODO("Not yet implemented")
    }


}