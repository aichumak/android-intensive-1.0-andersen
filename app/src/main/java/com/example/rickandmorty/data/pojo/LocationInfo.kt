package com.example.rickandmorty.data.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class LocationInfo(
    @SerializedName("count")
    @Expose
    val count: Int,

    @SerializedName("pages")
    @Expose
    val pages: Int,

    @SerializedName("next")
    @Expose
    val next: String,

    @SerializedName("prev")
    @Expose
    val prev: String
)