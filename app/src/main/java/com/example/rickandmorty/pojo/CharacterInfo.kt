package com.example.rickandmorty.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CharacterInfo (

    @SerializedName("id")
    @Expose
    private val id: Int? = null,

    @SerializedName("name")
    @Expose
    private val name: String? = null,

    @SerializedName("status")
    @Expose
    private val status: String? = null,

    @SerializedName("species")
    @Expose
    private val species: String? = null,

    @SerializedName("type")
    @Expose
    private val type: String? = null,

    @SerializedName("gender")
    @Expose
    private val gender: String? = null,

    @SerializedName("origin")
    @Expose
    private val origin: CharacterOriginInfo? = null,

    @SerializedName("location")
    @Expose
    private val location: CharacterLocationInfo? = null,

    @SerializedName("image")
    @Expose
    private val image: String? = null,

    @SerializedName("episode")
    @Expose
    private val episode: List<String>? = null,

    @SerializedName("url")
    @Expose
    private val url: String? = null,

    @SerializedName("created")
    @Expose
    private val created: String? = null

)