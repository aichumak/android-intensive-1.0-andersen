package com.example.rickandmorty.data.pojo

import androidx.room.TypeConverter

class LocationResidentInfoConverter {
    @TypeConverter
    fun fromArrayList(arrayList: List<String>): String {
        return arrayList.toString()
    }

    @TypeConverter
    fun toArrayList(params: String): List<String> {
        return arrayListOf(params)
    }
}