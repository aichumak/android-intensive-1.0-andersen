package com.example.rickandmorty.domain.locations

data class LocationObject(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: Array<String>,
    val url: String,
    val created: String
)