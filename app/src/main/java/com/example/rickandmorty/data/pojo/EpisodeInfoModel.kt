package com.example.rickandmorty.data.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episodes_list")
data class EpisodeInfoModel(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("air_date")
    @Expose
    val air_date: String,

    @SerializedName("episode")
    @Expose
    val episode: String,

    @SerializedName("characters")
    @Expose
    val characters: String,

    @SerializedName("url")
    @Expose
    val url: String,

    @SerializedName("created")
    @Expose
    val created: String
)