package com.example.rickandmorty.pojo

import androidx.room.TypeConverter

class CharacterOriginInfoConverter {

    @TypeConverter
    fun fromObject(characterOriginInfo: CharacterOriginInfo): String {
        return characterOriginInfo.toString()
    }

    @TypeConverter
    fun toObject(params: String): CharacterOriginInfo {
        val array = arrayListOf(params)
        return CharacterOriginInfo(array[0], array[1])
    }
}