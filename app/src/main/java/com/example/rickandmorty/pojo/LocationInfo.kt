package com.example.rickandmorty.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "locations_list")
data class LocationInfo(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("dimension")
    @Expose
    val dimension: String? = null,

    @SerializedName("residents")
    @Expose
    val residents: List<String>? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("created")
    @Expose
    val created: String? = null
)