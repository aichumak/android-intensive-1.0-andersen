package com.example.rickandmorty.data.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "locations_list")
data class LocationInfoModel(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("type")
    @Expose
    val type: String,

    @SerializedName("dimension")
    @Expose
    val dimension: String,

    @SerializedName("residents")
    @Expose
    val residents: String,

    @SerializedName("url")
    @Expose
    val url: String,

    @SerializedName("created")
    @Expose
    val created: String
)