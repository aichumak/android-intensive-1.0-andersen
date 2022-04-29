package com.example.rickandmorty.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class LocationInfo (
    @SerializedName("id")
    @Expose
    private val id: Int? = null,

    @SerializedName("name")
    @Expose
    private val name: String? = null,

    @SerializedName("type")
    @Expose
    private val type: String? = null,

    @SerializedName("dimension")
    @Expose
    private val dimension: String? = null,

    @SerializedName("residents")
    @Expose
    private val residents: List<String>? = null,

    @SerializedName("url")
    @Expose
    private val url: String? = null,

    @SerializedName("created")
    @Expose
    private val created: String? = null
)