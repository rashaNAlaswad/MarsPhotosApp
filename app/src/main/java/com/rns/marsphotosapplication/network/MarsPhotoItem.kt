package com.rns.marsphotosapplication.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarsPhotoItem(
    @Json(name = "id")
    val id: String,
    @Json(name = "img_src")
    val imgSrc: String
)