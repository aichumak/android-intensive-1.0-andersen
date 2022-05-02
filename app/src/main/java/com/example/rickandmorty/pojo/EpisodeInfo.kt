package com.example.rickandmorty.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "episodes_list")
data class EpisodeInfo(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("air_date")
    @Expose
    val airDate: String? = null,

    @SerializedName("episode")
    @Expose
    val episode: String? = null,

    @SerializedName("characters")
    @Expose
    val characters: List<String>? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("created")
    @Expose
    val created: String? = null
)