package com.example.rickandmorty.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.RickAndMorty
import com.example.rickandmorty.data.pojo.CharacterInfoModel

@Database([CharacterInfoModel::class], version = 1, exportSchema = false)
abstract class CharactersDataBase : RoomDatabase() {
    companion object {
        private var db: CharactersDataBase? = null
        private const val DB_NAME = "characters.db"
        private val LOCK = Any()

        fun getInstance(): CharactersDataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        RickAndMorty.getAppContext(),
                        CharactersDataBase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun characterInfoDao(): CharactersInfoDao
}