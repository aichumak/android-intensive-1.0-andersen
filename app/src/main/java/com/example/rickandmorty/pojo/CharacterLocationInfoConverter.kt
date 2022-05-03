package com.example.rickandmorty.pojo

import androidx.room.TypeConverter

class CharacterLocationInfoConverter {

    @TypeConverter
    fun fromObject(characterLocationInfo: CharacterLocationInfo): String {
        return characterLocationInfo.toString()
    }

    @TypeConverter
    fun toObject(params: String): CharacterLocationInfo {
        val array = arrayListOf(params)
        return CharacterLocationInfo(array[0], array[1])
    }
}