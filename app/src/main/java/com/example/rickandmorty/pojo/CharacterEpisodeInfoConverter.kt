package com.example.rickandmorty.pojo

import androidx.room.TypeConverter

class CharacterEpisodeInfoConverter {

    @TypeConverter
    fun fromArrayList(arrayList: List<String>): String {
        return arrayList.toString()
    }

    @TypeConverter
    fun toArrayList(params: String): List<String> {
        return arrayListOf(params)
    }
}