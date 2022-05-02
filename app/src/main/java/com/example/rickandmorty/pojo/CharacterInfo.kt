package com.example.rickandmorty.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters_list")
data class CharacterInfo(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("status")
    @Expose
    val status: String? = null,

    @SerializedName("species")
    @Expose
    val species: String? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("gender")
    @Expose
    val gender: String? = null,

    @SerializedName("origin")
    @Expose
    val origin: List<CharacterOriginInfo>? = null,

    @SerializedName("location")
    @Expose
    val location: List<CharacterLocationInfo>? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("episode")
    @Expose
    val episode: List<String>? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("created")
    @Expose
    val created: String? = null
)