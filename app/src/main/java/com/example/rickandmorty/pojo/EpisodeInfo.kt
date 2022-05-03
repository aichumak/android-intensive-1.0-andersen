package com.example.rickandmorty.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "episodes_list")
data class EpisodeInfo(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("air_date")
    @Expose
    val airDate: String,

    @SerializedName("episode")
    @Expose
    val episode: String,

    @SerializedName("characters")
    @Expose
    @TypeConverters(EpisodeCharacterInfoConverter::class)
    val characters: String,

    @SerializedName("url")
    @Expose
    val url: String,

    @SerializedName("created")
    @Expose
    val created: String
)