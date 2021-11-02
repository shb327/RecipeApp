package com.example.recipeapptest2.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true )
data class Recipes (

    @Json(name = "offset")
    val offset: Long,

    @Json(name = "number")
    val number: Long,

    @Json(name = "totalResults")
    val totalResults: Long,

    @Json(name = "results")
    val results: List<Recipe>

)

@JsonClass(generateAdapter = true)
data class Recipe (

    @Json(name = "id")
    val id: Long?,

    @Json(name = "title")
    val title: String?,

    @Json(name = "image")
    val image: String?,

    @Json(name = "imageType")
    val imageType: String?
)