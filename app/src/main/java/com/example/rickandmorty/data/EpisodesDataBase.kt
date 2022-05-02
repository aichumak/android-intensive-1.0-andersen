package com.example.rickandmorty.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.pojo.EpisodeInfo

@Database([EpisodeInfo::class], version = 1, exportSchema = false)
abstract class EpisodesDataBase : RoomDatabase() {
    companion object {
        private var db: EpisodesDataBase? = null
        private const val DB_NAME = "episodes.db"
        private val LOCK = Any()

        fun getInstance(context: Context): EpisodesDataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(context, EpisodesDataBase::class.java, DB_NAME).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun episodeInfoDao(): EpisodeInfoDao
}