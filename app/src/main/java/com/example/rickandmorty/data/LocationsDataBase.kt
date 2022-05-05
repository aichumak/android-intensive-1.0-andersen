package com.example.rickandmorty.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.pojo.LocationInfo
import com.example.rickandmorty.data.pojo.LocationInfoModel

@Database([LocationInfoModel::class], version = 1, exportSchema = false)
abstract class LocationsDataBase : RoomDatabase() {
    companion object {
        private var db: LocationsDataBase? = null
        private const val DB_NAME = "locations.db"
        private val LOCK = Any()

        fun getInstance(context: Context): LocationsDataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(context, LocationsDataBase::class.java, DB_NAME).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun locationInfoDao(): LocationInfoDao
}